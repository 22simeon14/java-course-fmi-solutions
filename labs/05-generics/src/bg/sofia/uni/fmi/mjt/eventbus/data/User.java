package bg.sofia.uni.fmi.mjt.eventbus.data;

public class User {

    private static int INITIAL_ID = 0;
    private final int id;
    private String username;
    private String email;

    public User(String username, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username can not be null or empty!");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email can not be null or empty!");
        }

        id = ++INITIAL_ID;
        this.username = username;
        this.email = email;
    }

    public int getUserId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUserEmail() {
        return this.email;
    }
}
