package client;

import command.Command;
import command.ConsultBalanceCommand;
import command.DepositCommand;
import command.TransferCommand;
import command.WithdrawCommand;
import invoker.AutomaticTellerMachine;
import receiver.BankAccount;

public class Main {

    public static void main(String[] args) {
        BankAccount sofiaAccount = new BankAccount("1001", "Sofia", 1000);
        BankAccount mateoAccount = new BankAccount("2002", "Mateo", 500);

        AutomaticTellerMachine atm = new AutomaticTellerMachine();

        Command consultSofia = new ConsultBalanceCommand(sofiaAccount);
        Command deposit = new DepositCommand(sofiaAccount, 200);
        Command withdraw = new WithdrawCommand(sofiaAccount, 150);
        Command transfer = new TransferCommand(sofiaAccount, mateoAccount, 300);
        Command consultMateo = new ConsultBalanceCommand(mateoAccount);

        System.out.println("--- Transaction 1: consult balance ---");
        atm.executeCommand(consultSofia);

        System.out.println("--- Transaction 2: deposit ---");
        atm.executeCommand(deposit);

        System.out.println("--- Transaction 3: withdraw ---");
        atm.executeCommand(withdraw);

        System.out.println("--- Transaction 4: transfer ---");
        atm.executeCommand(transfer);

        System.out.println("--- Consult both accounts ---");
        atm.executeCommand(consultSofia);
        atm.executeCommand(consultMateo);

        System.out.println("--- Undo the last 3 operations (2 consults + transfer) ---");
        atm.undoLastCommand();
        atm.undoLastCommand();
        atm.undoLastCommand();

        System.out.println("--- Final balances ---");
        atm.executeCommand(consultSofia);
        atm.executeCommand(consultMateo);
    }
}