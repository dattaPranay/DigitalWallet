package dao;

import model.User;
import model.Wallet;

import java.util.HashMap;
import java.util.Map;

public class WalletStore {
    private final Map<String, Wallet> walletMap;

    public WalletStore(Map<String, Wallet> walletMap) {
        this.walletMap = walletMap;
    }

    public WalletStore() {
        this.walletMap = new HashMap<>();
    }

    public Map<String, Wallet> getWalletMap() {
        return walletMap;
    }

    public boolean addWallet(Wallet wallet){
        if (walletMap.containsKey(walletMap.containsKey(wallet.getId()))) {
            System.out.println("already exist wallet");
            return false;
        }
        walletMap.put(wallet.getId(), wallet);
        return true;
    }
    public Wallet getWallet(String wallet) {
        if (!walletMap.containsKey(wallet)) {
            System.out.println("No wallet found with this id " + wallet);
            return null;
        }
        return walletMap.get(wallet);
    }

}
