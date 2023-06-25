package services;

import dao.WalletStore;
import model.Transaction;
import model.User;
import model.Wallet;

import java.math.BigDecimal;
import java.util.Date;

public class WalletService {
    private final WalletStore walletStore;

    private boolean validateUserWallet(User user, String walletId) {
        if (!user.getWalletMap().containsKey(walletId)) {
            System.out.println("invalid walllet ID");
            return false;
        }
        return true;
    }
    public WalletService(WalletStore walletStore) {
        this.walletStore = walletStore;

    }

    public boolean createWallet(User user, String name) {
        Wallet newWallet = new Wallet(name);
        walletStore.addWallet(newWallet);
        user.addWallet(newWallet);
        System.out.println("wallet successfully created" + newWallet.toString());
        return true;
    }

    public boolean addWalletBalance(User user, String walletId ,String amount) {
        if (!validateUserWallet(user, walletId)) {
            return false;
        }
        Wallet wallet = user.getWalletMap().get(walletId);
        wallet.addBalance(amount);
        System.out.println("wallet current balance is " +  wallet.getBalance());
        return true;
    }

    public boolean sendMoney (User user, String toWalletId, String fromWalletId, String amount) {
        if (!validateUserWallet(user, fromWalletId)) {
            return false;
        }
        Wallet toWallet = walletStore.getWallet(toWalletId);
        Wallet fromWallet = walletStore.getWallet(fromWalletId);
        if (fromWallet.getBalance().subtract(new BigDecimal(amount)).compareTo(BigDecimal.ZERO) <= 0 ) {
            System.out.println("insufficient balance, current balance " + fromWallet.getBalance());
            return false;
        }
        toWallet.addBalance(amount);
        fromWallet.addBalance( "-" + amount);
        Transaction transaction = new Transaction(toWalletId,fromWalletId, new Date(), new BigDecimal(amount));
        fromWallet.addTransaction(transaction);
        toWallet.addTransaction(transaction);
        System.out.println(transaction.toString());
        return true;
    }

    public void statement(User user, String walletId) {
        if (validateUserWallet(user, walletId)) {
            Wallet wallet = walletStore.getWallet(walletId);
            wallet.getTransactionList().stream().forEach(transaction -> System.out.println(transaction.toString()));
        }
    }

    public void overView(User user) {
        user.getWalletMap().entrySet().forEach(stringWalletEntry -> System.out.println(stringWalletEntry.getValue().toString()));
    }
}
