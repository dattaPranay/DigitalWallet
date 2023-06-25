package model;

public class UserIdGenerator {
    private static UserIdGenerator userIdGenerator;
    private Integer userId;


    private UserIdGenerator(Integer id) {
        this.userId = id;
    }

    public static String getUserId() {
        if (userIdGenerator == null) {
            userIdGenerator = new UserIdGenerator(0);
        }
        userIdGenerator.userId++;
        return "U" + userIdGenerator.userId;
    }
}
