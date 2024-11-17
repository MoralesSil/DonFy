package pe.edu.upc.donfy.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.Users;
import pe.edu.upc.donfy.repositories.IUsersRepository;
import pe.edu.upc.donfy.serviceinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUsersRepository uR;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users users) {
        uR.save(users);
    }

    @Override
    public Users listId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

    @Override
    public Users listUsername(String username) {
        return uR.findUsersByUsername(username);
    }

    @Override
    public void update(Users users) {
        uR.save(users);
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public List<Float[]> saldoXusuario(String username) {
        return uR.saldoXusuario(username);
    }

    @Override
    public List<Users> rolesONG() {
        return uR.rolesONG();
    }

    @Override
    public Long findByUsername(String username) {
        Users user = uR.findUsersByUsername(username);
        return user.getId();
    }


    @Override
    public List<String[]> donantesXfecha(String startDate, String endDate) {
        return uR.donantesXfechas(startDate, endDate);
    }

    @Override
    public Users listByUsername(String username) {
        return uR.findOneByUsername(username);
    }
}
