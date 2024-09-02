package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> list();

    public void insert(Role role);
    public Role listId(int idRole);
    public void update(Role role);
    public void delete(int idRole);
}
