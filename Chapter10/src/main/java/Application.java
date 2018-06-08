import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan你要扫描那些组件 package
@SpringBootApplication
//@ComponentScan("com.course.server")
@ComponentScan("com.course")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);


    }
}
