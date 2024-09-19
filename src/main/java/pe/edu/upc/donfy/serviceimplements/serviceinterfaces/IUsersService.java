package pe.edu.upc.donfy.serviceimplements.serviceinterfaces;

import pe.edu.upc.donfy.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> list();

    public void insert(Users users);
    public Users listId(Long idUsuario);
    public void update(Users users);
    public void delete(Long idUsuario);

    public List<Users>rolesONG();
}
