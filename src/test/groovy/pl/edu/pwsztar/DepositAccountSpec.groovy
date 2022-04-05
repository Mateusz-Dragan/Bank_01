package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DepositAccountSpec extends Specification{

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "deposit amount for #user"(){

        given: "the account is created"
        def number = bank.createAccount()
        when: "deposit amount"
        def result = bank.deposit(accountNumber, amount)
        then: "check if amount deposited"
        result == true
        where:
        user   | accountNumber  | amount
        'John' | 1              | 50
        'Tom'  | 2              | 20
        'Mike' | 3              | 300
        'Todd' | 4              | 43
    }

}
