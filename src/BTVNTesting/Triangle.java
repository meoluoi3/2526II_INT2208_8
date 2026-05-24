package BTVNTesting;
public class Triangle {

    public static String classify(int a, int b, int c) {
        if (a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
            return "Invalid Input";
        }

        if (!(a + b > c && a + c > b && b + c > a)) {
            return "Not a Triangle";
        }

        if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {50, 0, 50}, {50, 50, 0}, {0, 50, 50},
                {50, 50, 101}, {50, 101, 50}, {101, 50, 50},
                {1, 2, 3}, {2, 3, 1}, {3, 2, 1},
                {1, 1, 1}, {50, 50, 50}, {100, 100, 100},
                {50, 50, 75}, {50, 75, 50}, {75, 50, 50},
                {2, 2, 3}, {2, 3, 2}, {3, 2, 2},
                {2, 3, 4}, {98, 99, 100}, {49, 50, 51}
        };

        String[] expected = {
                "Invalid Input", "Invalid Input", "Invalid Input",
                "Invalid Input", "Invalid Input", "Invalid Input",
                "Not a Triangle", "Not a Triangle", "Not a Triangle",
                "Equilateral", "Equilateral", "Equilateral",
                "Isosceles", "Isosceles", "Isosceles",
                "Isosceles", "Isosceles", "Isosceles",
                "Scalene", "Scalene", "Scalene"
        };

        int passed = 0;
        int total = inputs.length;

        System.out.printf("%-6s | %-18s | %-16s | %-16s | %s%n", "TC ID", "Input (a, b, c)", "Expected", "Actual", "Status");
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < total; i++) {
            int a = inputs[i][0];
            int b = inputs[i][1];
            int c = inputs[i][2];
            String exp = expected[i];

            String actual = classify(a, b, c);
            String status = actual.equals(exp) ? "PASS" : "FAIL";

            if (actual.equals(exp)) {
                passed++;
            }

            String inputStr = "(" + a + ", " + b + ", " + c + ")";
            System.out.printf("%-6d | %-18s | %-16s | %-16s | %s%n", (i + 1), inputStr, exp, actual, status);
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.printf(" Passed %d/%d Test Cases%n", passed, total);
    }
}