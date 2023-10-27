public class Main {
    public static void main(String[] args) {
        UserLogin1 userLogin = new UserLogin1();
        boolean loggedIn = userLogin.login();

        if (loggedIn) {
            VideoGameDatabase.main(args);
        } else {
            System.out.println("Login failed. VideoGame class will not be executed.");
        }
    }
}
