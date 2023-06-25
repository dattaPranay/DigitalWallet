package dao;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private final Map<Integer, User> userMap;

    public UserStore(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }

    public UserStore() {
        this.userMap = new HashMap<>();
    }
}
