package model;

public class WalletIdGenerator {
    private static volatile WalletIdGenerator userIdGenerator;
    private Integer walletId;
    private static Object mutex = new Object();

    private WalletIdGenerator(Integer id) {
        this.walletId = id;
    }

    public static String getWalletId() {
        if (userIdGenerator == null) {
            synchronized(mutex) {
                if (userIdGenerator == null)
                    userIdGenerator = new WalletIdGenerator(0);
            }
        }
        userIdGenerator.walletId++;
        return "W" + userIdGenerator.walletId;
    }
}
