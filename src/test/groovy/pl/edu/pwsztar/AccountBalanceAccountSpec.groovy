package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class AccountBalanceAccountSpec extends Specification {


    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "get amount for #user"() {

        given: "the account is created"
        def number = bank.createAccount()
        when: "get amount"
        def result = bank.accountBalance(accountNumber)
        then: "check if account exists"
        result != BankOperation.ACCOUNT_NOT_EXISTS
        where:
        user   | accountNumber
        'John' | 1
        'Tom'  | 2
        'Mike' | 3
        'Todd' | 4
    }

}