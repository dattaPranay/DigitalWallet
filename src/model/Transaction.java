package model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private final String to_wallet_id;
    private final String from_wallet_id;
    private final Date date;
    private final BigDecimal amount;

    public Transaction(String to_wallet_id, String from_wallet_id, Date date, BigDecimal amount) {
        this.to_wallet_id = to_wallet_id;
        this.from_wallet_id = from_wallet_id;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "to_wallet_id='" + to_wallet_id + '\'' +
                ", from_wallet_id='" + from_wallet_id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
