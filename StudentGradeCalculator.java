import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Create an array to hold the marks for each subject
        int[] marks = new int[numSubjects];
        
        // Input marks for each subject
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            
            // Validate the input to ensure it's within the range [0, 100]
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input. Marks should be between 0 and 100. Please enter again: ");
                marks[i] = scanner.nextInt();
            }
            
            totalMarks += marks[i];
        }
        
        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Determine the grade based on the average percentage
        String grade = determineGrade(averagePercentage);
        
        // Display the results
        System.out.printf("Total Marks: %d%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    // Method to determine the grade based on the average percentage
    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
