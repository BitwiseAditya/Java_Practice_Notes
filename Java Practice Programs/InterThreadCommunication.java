class Course {
    String courseName;
    int numOfSeats;

    public Course(String courseName, int numOfSeats) {
        this.courseName = courseName;
        this.numOfSeats = numOfSeats;
    }

    public synchronized void registerForCourse(int rollNo) {
        try {
            if (this.numOfSeats - 1 < 0) {
                this.wait(5000); // This releases the lock on the object and waits for 5 seconds
                if (this.numOfSeats - 1 < 0) // Check if any seat got released by the Cancellation
                    throw new Exception("No more seats available for this course");
            }
            System.out.println("Booking successful!");
            this.numOfSeats -= 1;
            System.out.println("Available seats: " + this.numOfSeats);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public synchronized void cancelSeats() {
        try {
            this.numOfSeats += 1;
            System.out.println("Cancellation successful!");
            System.out.println("Available seats: " + this.numOfSeats);
            this.notify(); // Notifies one of the waiting threads to resume
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class RegisterThread extends Thread {
    Course c;

    RegisterThread(Course c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.registerForCourse(1);
    }
}

class CancelRegistration extends Thread {
    Course c;

    CancelRegistration(Course c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.cancelSeats();
    }
}

class InterThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        Course cse = new Course("CSE", 1);
        RegisterThread regObj1 = new RegisterThread(cse);
        regObj1.start();
        RegisterThread regObj2 = new RegisterThread(cse);
        regObj2.start();

        Thread.sleep(2000);
        // Running a cancellation thread after 2 seconds
        CancelRegistration cancelObj1 = new CancelRegistration(cse);
        cancelObj1.start();
    }
}
