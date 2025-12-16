// program to demonstrate the working of an Anonymous Inner Class.

interface Grade {
    char calculateGrade(String employeeId);

    boolean isEmployeeExists(String employeeId);
}

class Manager {
    // Outer Class
    Grade grade = new Grade() { // Anonymous Inner Class
        private char grade;

        @Override
        public char calculateGrade(String employeeId) {
            if (employeeId.equals("E001")) {
                return 'A';
            } else if (employeeId.equals("E002")) {
                return 'B';
            } else {
                return 'C';
            }
        }

        @Override
        public boolean isEmployeeExists(String employeeId) {
            return employeeId.equals("E001") || employeeId.equals("E002");
        }

    };

    public char checkEmployeeId(String EmployeeId) {
        char gradePoint = grade.calculateGrade(EmployeeId);
        return gradePoint;
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Manager manager = new Manager();
        String employeeId = "E001";
        if (manager.grade.isEmployeeExists(employeeId)) {
            char gradePoint = manager.checkEmployeeId(employeeId);
            System.out.println("Employee ID: " + employeeId + ", Grade: " + gradePoint);
        } else {
            System.out.println("Employee ID: " + employeeId + " does not exist.");
        }
    }
}
