import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();

    int val();
}

public class AnnotationsExample {
    @MyAnno(str = "My Annotation", val = 100)
    public static void meth() {
        AnnotationsExample ob = new AnnotationsExample();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("meth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        meth();
    }
}
