package model;

import java.util.HashMap;
import java.util.Map;

import static model.UserIdGenerator.getUserId;

public class User {
    private final String id;
    private final String name;
    private Map<String, Wallet> walletMap;

    public User(String name) {
        this.name = name;
        this.id = getUserId();
        walletMap = new HashMap<>();
        System.out.println("user created id " + id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Wallet> getWalletMap() {
        return walletMap;
    }

    public void addWallet(Wallet wallet) {
        this.walletMap.put(wallet.getId(), wallet);
    }
}
