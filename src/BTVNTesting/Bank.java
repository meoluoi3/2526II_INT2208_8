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
}


