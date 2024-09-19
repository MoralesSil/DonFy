package pe.edu.upc.donfy.serviceimplements.serviceimplements;

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
    public void update(Users users) {
        uR.save(users);
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public List<Users> rolesONG() {
        return uR.rolesONG();
    }


}
