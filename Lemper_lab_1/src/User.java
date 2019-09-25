import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int role;
    private String login;
    private String psswd;
    private String rolename;
    private DAOUser userdb = new DAOUser();
    private DAORole roledb = new DAORole();

    public User() {
    }

    public User(int id, String name, String surname, int age, int role, String login, String psswd) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.role = role;
        this.login = login;
        this.psswd = psswd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public boolean create() {
        return this.userdb.create(this);
    }

    public boolean createRole() {
        return this.roledb.create(this);
    }

    public ArrayList<User> showAllUsers() {
        return this.userdb.showAll();
    }

    public ArrayList<User> showAllRoles() {
        return this.roledb.showAll();
    }

    public User readUser(int id) {
        return this.userdb.read(id);
    }

    public User readRole(int id) {
        return this.roledb.read(id);
    }

    public boolean updateUser() {
        return this.userdb.update(this);
    }

    public boolean updateRole() {
        return this.roledb.update(this);
    }

    public boolean deleteUser() {
        return this.userdb.delete(this);
    }

    public boolean deleteRole() {
        return this.roledb.delete(this);
    }

    @Override
    public String toString() {
        return id +
                "\t" + name
                + "\t" + surname
                + "\t" + age
                + "\t" + role
                + "\t" + login
                + "\t" + psswd;
    }

    public String roleToString() {
        return role
                + "\t" + rolename;
    }
}
