import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAORole implements DAO<User> {

    static Connection conn;
    final String QUERY1="Select * from role";
    static {
        try {
            conn = Conn.GetConn();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean create(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("INSERT INTO role (\n" +
                    "                     role\n" +
                    "                 )\n" +
                    "                 VALUES (\n" +
                    "                     '" + obj.getRolename() + "'\n" +
                    "                 );\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public User read(int id) {
        User user = null;
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT id,\n" +
                    "       role\n" +
                    "  FROM role" +
                    "  WHERE id = '" + id + "';\n");
            if(rs.next()) {
                String role = rs.getString("role");
                user = new User();
                user.setRole(id);
                user.setRolename(role);
            }
            return user;
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("UPDATE role\n" +
                    "   SET role = '" + obj.getRolename() + "'\n" +
                    " WHERE id = '" + obj.getRole() + "';\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(User obj) {
        try {
            Statement s = conn.createStatement();
            s.execute("DELETE FROM role\n" +
                    "      WHERE id = '" + obj.getRole() + "';\n");
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<User> showAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT id,\n" +
                    "       role\n" +
                            "  FROM role");
            while (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                User user = new User();
                user.setRole(id);
                user.setRolename(role);
                users.add(user);
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
}
