import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ChangeDetail {
    String authorName();

    String methodName();
}

abstract class NewStudent {
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    abstract void calculateFee();
}

@ChangeDetail(authorName = "Emily", methodName = "calculateFee")
class DayScholar extends NewStudent {
    @Override
    public void calculateFee() {
        // Code for calculating total fee which includes bus fee
    }
}

class CustomAnnotations {
    public static void main(String[] args) throws Exception {
        NewStudent student = new DayScholar();
        Class c = student.getClass();
        // Fetches the list of annotations of the class, DayScholar
        Annotation annotations[] = c.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            // Print the name of the annotation
            System.out.println(annotation.annotationType().getName());
            // Fetches the list of attributes of the annotation
            Method[] fields = annotation.annotationType().getDeclaredMethods();
            for (Method field : fields) {
                // Print the attribute name
                System.out.print(field.getName());
                // Fetch the value for the attribute
                Object value = field.invoke(annotation, (Object[]) null);
                System.out.println("\t" + value);
            }
        }
    }
}
