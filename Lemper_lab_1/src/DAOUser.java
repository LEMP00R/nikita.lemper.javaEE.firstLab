import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUser implements DAO<User> {

    static Connection conn;
    final String QUERY1="Select * from user";
    static {
        try {
            conn = Conn.GetConn();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean create(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("INSERT INTO user (\n" +
                    "                     name,\n" +
                    "                     surname,\n" +
                    "                     age,\n" +
                    "                     role,\n" +
                    "                     login,\n" +
                    "                     psswd\n" +
                    "                 )\n" +
                    "                 VALUES (\n" +
                    "                     '" + obj.getName() + "',\n" +
                    "                     '" + obj.getSurname() + "',\n" +
                    "                     '" + obj.getAge() + "',\n" +
                    "                     '" + obj.getRole() + "',\n" +
                    "                     '" + obj.getLogin() + "',\n" +
                    "                     '" + obj.getPsswd() + "'\n" +
                    "                 );\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<User> showAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT id,\n" +
                    "       name,\n" +
                    "       surname,\n" +
                    "       age,\n" +
                    "       role,\n" +
                    "       login,\n" +
                    "       psswd\n" +
                    "  FROM user;\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                int role = rs.getInt("role");
                String login = rs.getString("login");
                String psswd = rs.getString("psswd");
                users.add(new User(id, name, surname, age, role, login, psswd));
            }
            if (!users.isEmpty()) {
                return users;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("UPDATE user\n" +
                    "   SET name = '" + obj.getName() + "',\n" +
                    "       surname = '" + obj.getSurname() + "',\n" +
                    "       age = '" + obj.getAge() + "',\n" +
                    "       role = '" + obj.getRole() + "',\n" +
                    "       login = '" + obj.getLogin() + "',\n" +
                    "       psswd = '" + obj.getPsswd() + "'\n" +
                    " WHERE id = '" + obj.getId() + "';\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("DELETE FROM user\n" +
                    "      WHERE id = '" + obj.getId() + "';\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public User read(int id) {
        User user = null;
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT id,\n" +
                    "       name,\n" +
                    "       surname,\n" +
                    "       age,\n" +
                    "       role,\n" +
                    "       login,\n" +
                    "       psswd\n" +
                    "  FROM user\n" +
                    "  WHERE id = '" + id + "';\n");
            if(rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                int role = rs.getInt("role");
                String login = rs.getString("login");
                String psswd = rs.getString("psswd");
                user = new User(id, name, surname, age, role, login, psswd);
            }
            return user;
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
