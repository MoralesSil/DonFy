package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> list();

    public void insert(Users users);
    public Users listId(int idUsuario);
    public void update(Users users);
    public void delete(int idUsuario);
}
