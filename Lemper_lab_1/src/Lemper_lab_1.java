import java.util.ArrayList;
import java.util.Scanner;


public class Lemper_lab_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        while (number != 7){
            switch (number){
                case 1:
                    caseOne();
                    number = 0;
                    break;
                case 2:
                    caseTwo();
                    number = 0;
                    break;
                case 3:
                    caseThree();
                    number = 0;
                    break;
                case 4:
                    caseFour();
                    number = 0;
                    break;
                case 5:
                    caseFive();
                    number = 0;
                    break;
                case 6:
                    caseSix();
                    number = 0;
                    break;
                default:
                    System.out.println("1.Добавить пользователя.\n" +
                            "2.Изменить пользователя.\n" +
                            "3.Удалить пользователя.\n" +
                            "4.Добавить роль.\n" +
                            "5.Изменить роль.\n" +
                            "6.Удалить роль.\n" +
                            "7.Выход.\n");
                    number = scan.nextInt();
                    break;
            }
        }
    }

    private static void caseOne(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scan.next();
        System.out.println("Введите фамилию: ");
        String surname = scan.next();
        System.out.println("Введите возраст: ");
        int age = scan.nextInt();
        tableRoles();
        System.out.println("Введите роль (№): ");
        int role = scan.nextInt();
        System.out.println("Введите логин: ");
        String login = scan.next();
        System.out.println("Введите пароль: ");
        String psswd = scan.next();
        User user = new User(0, name, surname, age, role, login, psswd);
        if(user.create()){
            System.out.println("Пользователь добавлен!");
        } else {
            System.out.println("Упс... пользователь не добавился.");
        }
    }

    private static void caseTwo(){
        Scanner scan = new Scanner(System.in);
        tableUsers();
        System.out.println("Введите № пользователя, которого хотите изменить: ");
        int id = scan.nextInt();
        User user = new User().readUser(id);
        if (user != null){
            int number = 0;
            while (number != 7){
                switch (number){
                    case 1:
                        System.out.println("Введите новое имя: ");
                        String name = scan.next();
                        user.setName(name);
                        number = 0;
                        break;
                    case 2:
                        System.out.println("Введите новую фамилию: ");
                        String surname = scan.next();
                        user.setSurname(surname);
                        number = 0;
                        break;
                    case 3:
                        System.out.println("Введите новый возраст: ");
                        int age = scan.nextInt();
                        user.setAge(age);
                        number = 0;
                        break;
                    case 4:
                        tableRoles();
                        System.out.println("Введите новую роль (№): ");
                        int role = scan.nextInt();
                        user.setRole(role);
                        number = 0;
                        break;
                    case 5:
                        System.out.println("Введите новый логин: ");
                        String login = scan.next();
                        user.setLogin(login);
                        number = 0;
                        break;
                    case 6:
                        System.out.println("Введите новый пароль: ");
                        String psswd = scan.next();
                        user.setPsswd(psswd);
                        number = 0;
                        break;
                    default:
                        System.out.println("1.Изменить имя.\n" +
                                "2.Изменить фамилию.\n" +
                                "3.Изменить возраст.\n" +
                                "4.Изменить роль.\n" +
                                "5.Изменить логин.\n" +
                                "6.Изменить пароль.\n" +
                                "7.Сохранить.");
                        number = scan.nextInt();
                        break;
                }
            }
            if(user.updateUser()){
                System.out.println("Пользователь сохранен!");
            } else {
                System.out.println("Упс... пользователь не сохранился.");
            }
        } else {
            System.out.println("Упс... пользователь не найден.");
        }
    }

    private static void caseThree() {
        Scanner scan = new Scanner(System.in);
        tableUsers();
        System.out.println("Введите № пользователя, которого хотите удалить: ");
        int id = scan.nextInt();
        User user = new User().readUser(id);
        if (user != null){
            if(user.deleteUser()){
                System.out.println("Пользователь удален!");
            } else {
                System.out.println("Упс... пользователь не удалился.");
            }
        } else {
            System.out.println("Упс... пользователь не найден.");
        }
    }

    private static void caseFour() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите роль: ");
        String role = scan.next();
        User user = new User();
        user.setRolename(role);
        if(user.createRole()){
            System.out.println("Роль добавлена!");
        } else {
            System.out.println("Упс... роль не добавилась.");
        }
    }

    private static void caseFive() {
        Scanner scan = new Scanner(System.in);
        tableRoles();
        System.out.println("Введите роль, которую хотите изменить (№): ");
        int roleid = scan.nextInt();
        User user = new User().readRole(roleid);
        if (user != null) {
            System.out.println("Введите новое название роли: ");
            String role = scan.next();
            user.setRolename(role);
            if (user.updateRole()) {
                System.out.println("Роль сохранена!");
            } else {
                System.out.println("Упс... роль не сохранилась.");
            }
        } else {
            System.out.println("Упс... роль не найдена.");
        }
    }

    private static void caseSix() {
        Scanner scan = new Scanner(System.in);
        tableRoles();
        System.out.println("Введите № роли, которую хотите удалить: ");
        int id = scan.nextInt();
        User user = new User().readRole(id);
        if (user != null){
            if(user.deleteRole()){
                System.out.println("Роль удалена!");
            } else {
                System.out.println("Упс... роль не удалилась.");
            }
        } else {
            System.out.println("Упс... роль не найдена.");
        }
    }

    private static void tableUsers(){
        ArrayList<User> users = new User().showAllUsers();
        if(users != null) {
            System.out.println("id" +
                    "\t" + "имя"
                    + "\t" + "фамилия"
                    + "\t" + "возраст"
                    + "\t" + "роль"
                    + "\t" + "логин");
            for (User user : users){
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Таблица еще пуста.");
        }
    }

    private static void tableRoles(){
        ArrayList<User> users = new User().showAllRoles();
        if(users != null) {
            System.out.println("id" +
                    "\t" + "роль");
            for (User user : users){
                System.out.println(user.roleToString());
            }
        } else {
            System.out.println("Таблица еще пуста.");
        }
    }
}
