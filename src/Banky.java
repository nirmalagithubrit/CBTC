import java.util.*;
class Account {
    private String accountId;
    private double initialBalance;

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return initialBalance;
    }

    public void deposit(double amount) {
    	initialBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (initialBalance >= amount) {
        	initialBalance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }
}
class Bank {
    public Map<String, Account> accounts=new HashMap<>();
    public void createAccount(String accountId, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            Account account = new Account(accountId, initialBalance);
            accounts.put(accountId, account);
            System.out.println("Account created successfully");
        } else {
            System.out.println("Account already exists");
        }
    }

    public void deposit(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful");
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful");
            }
        } else {
            System.out.println("Account not found");
        }
    }

    public void transfer(String AccountId1, String AccountId2, double amount) {
        Account fromAccount = accounts.get(AccountId1);
        Account toAccount = accounts.get(AccountId2);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transfer successful");
            }
        } else {
            System.out.println("One or both accounts not found");
        }
    }
}

public class Banky {

	public static void main(String[] args) {
		        Bank bank = new Bank();
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            System.out.println("\nBankY - Choose an option:");
		            System.out.println("1. Create Account");
		            System.out.println("2. Deposit");
		            System.out.println("3. Withdraw");
		            System.out.println("4. Transfer");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");

		            int choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter account ID: ");
		                    String accountId = scanner.next();
		                    System.out.print("Enter initial balance: ");
		                    double initialBalance = scanner.nextDouble();
		                    bank.createAccount(accountId, initialBalance);
		                    break;
		                case 2:
		                    System.out.print("Enter account ID: ");
		                    String depositAccount= scanner.next();
		                    System.out.print("Enter amount to deposit: ");
		                    double Amount = scanner.nextDouble();
		                    bank.deposit(depositAccount,Amount);
		                    break;
		                case 3:
		                    System.out.print("Enter account ID: ");
		                    String withdrawAccount = scanner.next();
		                    System.out.print("Enter amount to withdraw: ");
		                    double withdrawAmount = scanner.nextDouble();
		                    bank.withdraw(withdrawAccount, withdrawAmount);
		                    break;
		                case 4:
		                    System.out.print("Enter account ID to transfer from: ");
		                    String fromAccount = scanner.next();
		                    System.out.print("Enter account ID to transfer to: ");
		                    String toAccount = scanner.next();
		                    System.out.print("Enter amount to transfer: ");
		                    double transferAmount = scanner.nextDouble();
		                    bank.transfer(fromAccount, toAccount, transferAmount);
		                    break;
		                case 5:
		                    System.out.println("Exiting BankY. Thanks for choosing");
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		    }
		}


	}

}
