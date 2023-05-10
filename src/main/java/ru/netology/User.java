package ru.netology;

public class User {

    private String login;
    private String password;
    private String email;
    private int age;

    public User(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "pass1", "jhon@gmail.com", 24);
        User user2 = new User("alex", "pass2", "alex@gmail.com", 32);
        User user3 = new User("peter", "pass3", "peter@gmail.com", 17);
        User user4 = new User("max", "pass4", "max@gmail.com", 45);
        User user5 = new User("jim", "pass5", "jim@gmail.com", 16);
        return new User[]{user1, user2, user3, user4, user5,};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();

        for (User user : users) {
            if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");

    }

    public static boolean validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ запрещен. Пользователю менее 18 лет.");
        }else{
            return true;
        }
    }
    public String getLogin() {

        return this.login;
    }

    public void setLogin(User user, String login) {

        this.login = user.login;
    }

    public String getPassword() {

        return this.password;
    }

    public void setPassword(User user, String password) {

        this.password = user.password;
    }

    public String getEmail() {

        return this.password;
    }

    public void setEmail(User user, String email) {

        this.email = user.email;
    }

    public int getAge() {

        return this.age;
    }

    public void setAge(User user, int age) {

        this.age = user.age;
    }

}


