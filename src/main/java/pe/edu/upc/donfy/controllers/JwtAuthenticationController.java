package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.RoleDTO;
import pe.edu.upc.donfy.dtos.UsersDTO;
import pe.edu.upc.donfy.entities.Role;
import pe.edu.upc.donfy.entities.Users;
import pe.edu.upc.donfy.securities.JwtRequest;
import pe.edu.upc.donfy.securities.JwtResponse;
import pe.edu.upc.donfy.securities.JwtTokenUtil;
import pe.edu.upc.donfy.serviceimplements.JwtUserDetailsService;
import pe.edu.upc.donfy.serviceinterfaces.IRoleService;
import pe.edu.upc.donfy.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private IUsersService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService rS;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/user/id/{username}")
    public Long getUserIdByUsername(@PathVariable String username) {
        return uS.findByUsername(username);
    }

    @PostMapping("/registrar")
    public void registar(@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users urs = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(urs.getPassword());
        urs.setPassword(encodedPassword);
        uS.insert(urs);
    }

    @GetMapping("/usuario")
    public List<UsersDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/rol")
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role nt = m.map(dto, Role.class);
        rS.insert(nt);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }


    }
}