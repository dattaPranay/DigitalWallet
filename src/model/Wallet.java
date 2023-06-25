package model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static model.WalletIdGenerator.getWalletId;

public class Wallet {
    private final String id;
    public String name;
    private BigDecimal balance;

    private final List<Transaction> transactionList;

    public Wallet(String name) {
        balance = new BigDecimal("0");
        this.name = name;
        id = getWalletId();
        this.transactionList = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public void addBalance(String amount) {
        this.balance = this.balance.add(new BigDecimal(amount));
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
