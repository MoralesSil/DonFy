package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> list();

    public void insert(Users users);
    public Users listId(Long idUsuario);
    public void update(Users users);
    public void delete(Long idUsuario);
    public List<Float[]> saldoXusuario(String username);

    public List<Users>rolesONG();

    public Long  findByUsername(String username);

    public List<String[]> donantesXfecha(String startDate,String endDate);

}
