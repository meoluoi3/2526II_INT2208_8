package BTVNTesting;

public class Bank {
    public static String checkRiskLevel(int credit_score) {
        if ((credit_score < 300) || (credit_score > 850)) return "Invalid Input";
        if (credit_score <= 500) return "High";
        else if (credit_score <= 700) return "Medium";
        else return "Low";
    }

    public static String processLoan(int age, double income, int credit_score, char employment) {
        if (age < 18 || age > 65) return "Invalid Input";
        if (income < 5.0 || income > 500.0) return "Invalid Input";
        if (credit_score < 300 || credit_score > 850) return "Invalid Input";
        if (employment != 'C' && employment != 'F') return "Invalid Input";

        String riskLevel = checkRiskLevel(credit_score);

        if (riskLevel.equals("High")) return "REJECT";

        if (income < 15.0) {
            if (employment == 'F' || riskLevel.equals("Medium")) {
                return "REJECT";
            }
            if (employment == 'C' && riskLevel.equals("Low")) {
                return "MANUAL REVIEW";
            }
        } else {
            if (employment == 'C') {
                return "APPROVE";
            }
            if (employment == 'F') {
                return "MANUAL REVIEW";
            }
        }

        return "UNKNOWN";
    }

    public static void main(String[] args) {
        Object[][] testCases = {
                {17, 50.0, 600, 'C', "Invalid Input"},
                {66, 50.0, 600, 'C', "Invalid Input"},
                {30, 4.9, 600, 'C', "Invalid Input"},
                {30, 500.1, 600, 'C', "Invalid Input"},
                {30, 50.0, 299, 'C', "Invalid Input"},
                {30, 50.0, 851, 'C', "Invalid Input"},
                {30, 50.0, 600, 'X', "Invalid Input"},
                {18, 5.0, 300, 'C', "REJECT"},
                {65, 500.0, 500, 'F', "REJECT"},
                {30, 14.9, 501, 'C', "REJECT"},
                {35, 10.0, 850, 'F', "REJECT"},
                {40, 5.0, 701, 'C', "MANUAL REVIEW"},
                {50, 15.0, 700, 'C', "APPROVE"},
                {60, 500.0, 750, 'F', "MANUAL REVIEW"}
        };

        int passed = 0;
        System.out.printf("%-5s | %-24s | %-16s | %-16s | %s%n", "TC ID", "Input", "Expected", "Actual", "Status");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < testCases.length; i++) {
            int age = (int) testCases[i][0];
            double income = (double) testCases[i][1];
            int creditScore = (int) testCases[i][2];
            char employment = (char) testCases[i][3];
            String expected = (String) testCases[i][4];

            String actual = processLoan(age, income, creditScore, employment);
            String status = actual.equals(expected) ? "PASS" : "FAIL";
            if (actual.equals(expected)) passed++;

            String inputStr = String.format("(%d, %.1f, %d, '%c')", age, income, creditScore, employment);
            System.out.printf("TC%02d  | %-24s | %-16s | %-16s | %s%n", (i + 1), inputStr, expected, actual, status);
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("Kết quả: Passed %d/%d Test Cases.%n", passed, testCases.length);
    }
}


