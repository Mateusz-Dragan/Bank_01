package pl.edu.pwsztar;

import java.util.List;
import java.util.Random;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private int accountNumber = 0;
    private int balance = 0;

    public int createAccount() {
        Random rand = new Random();
        balance = rand.nextInt(5000);
        return ++accountNumber;
    }

    public int deleteAccount(int accountNumber) {
        if (this.accountNumber == accountNumber){
            return ACCOUNT_NOT_EXISTS;
        }
        return 0;
    }

    public boolean deposit(int accountNumber, int amount) {
        if (this.accountNumber == accountNumber){
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, int amount) {
        if (this.accountNumber == accountNumber && balance > amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        return false;
    }

    public int accountBalance(int accountNumber) {
        if (this.accountNumber == accountNumber){

            return balance;
        }
        return ACCOUNT_NOT_EXISTS;
    }

    public int sumAccountsBalance() {
        return 0;
    }
}
