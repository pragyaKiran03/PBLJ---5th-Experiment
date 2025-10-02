import java.util.ArrayList;
import java.util.Scanner;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'stop' to finish): ");
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            // Parsing string input into int and autoboxing into Integer
            int value = Integer.parseInt(input);
            numbers.add(value); // Autoboxing happens here
        }

        int sum = 0;
        // Enhanced for-loop with unboxing
        for (Integer num : numbers) {
            sum += num; // Unboxing Integer -> int
        }

        System.out.println("The sum of entered integers is: " + sum);
        sc.close();
    }
}
