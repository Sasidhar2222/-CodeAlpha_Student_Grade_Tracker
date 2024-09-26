import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<Double> grades;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findHighest() {
        if (grades.isEmpty()) return 0;
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public double findLowest() {
        if (grades.isEmpty()) return 0;
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public void displayGrades() {
        System.out.println("Grades: " + grades);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();
        String input;

        System.out.println("Enter student grades (type 'exit' to finish):");
        
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                tracker.addGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or 'exit' to finish.");
            }
        }

        tracker.displayGrades();
        System.out.printf("Average: %.2f%n", tracker.calculateAverage());
        System.out.printf("Highest: %.2f%n", tracker.findHighest());
        System.out.printf("Lowest: %.2f%n", tracker.findLowest());

        scanner.close();
    }
}