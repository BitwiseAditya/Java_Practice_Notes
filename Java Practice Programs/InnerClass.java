
class Manager { // Outer Class
    private class Grade { // Inner Class
        private char grade;

        private char calculateGrade(String employeeid, int point) {
            if (isEmployeeExists(employeeid)) {
                if (point < 100 && point >= 90) {
                    grade = 'A';
                } else if (point < 90 && point >= 80) {
                    grade = 'B';
                } else {
                    grade = 'C';
                }

            }
            return grade;
        }

        // Check if the employee id exists or not
        private boolean isEmployeeExists(String employeeId) {
            // check from database or file system
            return true;
        }

    }

    public char CheckEmployeeID(String employeeId, int point) {
        Grade grade = new Grade();
        return grade.calculateGrade(employeeId, point);
    }

}

public class InnerClass {
    public static void main(String[] args) {
        Manager manager = new Manager();
        String employeeId = "I1001";
        char gradePoint = manager.CheckEmployeeID(employeeId, 80);
        System.out.println("The grade for " + employeeId + " is " + gradePoint);
    }
}

/*
 * class Customer {
 * private String name;
 * 
 * private Customer(String name) {
 * this.name = name;
 * }
 * 
 * private class Account { // Line 1
 * private String accountNo = "name is empty";
 * int count = 100;
 * 
 * public String generateAccount() {
 * if (!name.isEmpty()) { // Line 2
 * accountNo = "Acc" + count + 1;
 * }
 * return accountNo;
 * }
 * }
 * 
 * public static void main(String[] args) {
 * Customer c = new Customer("John");// Line 3
 * Customer.Account acc = c.new Account();
 * System.out.println(acc.generateAccount());
 * }
 * }
 */
