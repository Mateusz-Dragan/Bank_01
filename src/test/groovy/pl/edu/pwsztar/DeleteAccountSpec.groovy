package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification{

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "delete account #user for #accountNumber if it doesn't exists"(){

        given: "the account is created"
        def number = bank.createAccount()
        when: "the account is deleted"
        def result = bank.deleteAccount(fakeAccountNumber)
        then: "check if account is deleted"
            result == BankOperation.ACCOUNT_NOT_EXISTS
        where:
        user   | accountNumber  | fakeAccountNumber
        'John' | 1              | 1
        'Tom'  | 2              | 2
        'Mike' | 3              | 3
        'Todd' | 4              | 4
    }

}
