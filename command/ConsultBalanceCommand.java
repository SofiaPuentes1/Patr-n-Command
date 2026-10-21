package command;

import receiver.BankAccount;

public class ConsultBalanceCommand implements Command {

    private BankAccount account;

    public ConsultBalanceCommand(BankAccount account) {
        this.account = account;
    }

    public void execute() {
        System.out.println("Balance of account " + account.getAccountNumber() + " ("
                + account.getOwner() + "): " + account.checkBalance());
    }

    public void undo() {
        System.out.println("A balance inquiry cannot be undone");
    }
}