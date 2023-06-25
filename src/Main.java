import dao.WalletStore;
import model.User;
import services.WalletService;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        User userA = new User("ram");
        User userB = new User("sam");
        WalletService walletService = new WalletService(new WalletStore());
        String file = "C:\\Users\\Pranay\\IdeaProjects\\digital_wallet\\src\\input.txt";
        Scanner sc = new Scanner(new File(file));
        User curUser = null;
        outer: while (true) {
            System.out.println("\nOPTIONS:");
            System.out.println("1. enter User id: ");
            String wallet;
            String amt;
            switch (sc.nextLine()) {
                case "U1":
                    curUser = userA;
                    break;
                case "U2":
                    curUser = userB;
                    break;
                case "q": break outer;
            }
            inner: while (true) {
                System.out.println("\nOPTIONS:");
                System.out.println("1. Create wallet");
                System.out.println("2. add Amount");
                System.out.println("3. Transfer Amount");
                System.out.println("4. Account Statement");
                System.out.println("5. Overview");
                System.out.println("6. Exit");
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:
                        System.out.println("enter wallet name");
                        walletService.createWallet(curUser, sc.nextLine());
                        break;
                    case 2:
                        System.out.println("enter Amount ");
                        amt =  sc.nextLine();
                        System.out.println("enter wallet id ");
                        wallet = sc.nextLine();
                        walletService.addWalletBalance(curUser, wallet, amt);
                        break;
                    case 3:
                        System.out.println("enter Amount to transfer");
                        amt =  sc.nextLine();
                        System.out.println("enter ur wallet id ");
                        wallet = sc.nextLine();
                        System.out.println("enter to wallet id ");
                        String toWallet = sc.nextLine();
                        walletService.sendMoney(curUser, toWallet, wallet,amt);
                        break;
                    case 4:
                        System.out.println("enter ur wallet id ");
                        walletService.statement(curUser, sc.nextLine());
                        break;
                    case 5:
                        walletService.overView(curUser);
                        break;
                    case 6:
                        break inner;
                }
            }



        }
    }
}