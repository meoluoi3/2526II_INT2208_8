package BTVNTesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testInvalidAge() {
        assertEquals("Invalid Input", Bank.processLoan(17, 50.0, 600, 'C'));
        assertEquals("Invalid Input", Bank.processLoan(66, 50.0, 600, 'C'));
    }

    @Test
    public void testInvalidIncome() {
        assertEquals("Invalid Input", Bank.processLoan(30, 4.9, 600, 'C'));
        assertEquals("Invalid Input", Bank.processLoan(30, 500.1, 600, 'C'));
    }

    @Test
    public void testInvalidCreditScore() {
        assertEquals("Invalid Input", Bank.processLoan(30, 50.0, 299, 'C'));
        assertEquals("Invalid Input", Bank.processLoan(30, 50.0, 851, 'C'));
    }

    @Test
    public void testInvalidEmployment() {
        assertEquals("Invalid Input", Bank.processLoan(30, 50.0, 600, 'X'));
    }

    @Test
    public void testHighRiskReject() {
        assertEquals("REJECT", Bank.processLoan(18, 5.0, 300, 'C'));
        assertEquals("REJECT", Bank.processLoan(65, 500.0, 500, 'F'));
    }

    @Test
    public void testLowIncomeReject() {
        assertEquals("REJECT", Bank.processLoan(30, 14.9, 501, 'C'));
        assertEquals("REJECT", Bank.processLoan(35, 10.0, 850, 'F'));
    }

    @Test
    public void testManualReview() {
        assertEquals("MANUAL REVIEW", Bank.processLoan(40, 5.0, 701, 'C'));
        assertEquals("MANUAL REVIEW", Bank.processLoan(60, 500.0, 750, 'F'));
    }

    @Test
    public void testApprove() {
        assertEquals("APPROVE", Bank.processLoan(50, 15.0, 700, 'C'));
    }
}