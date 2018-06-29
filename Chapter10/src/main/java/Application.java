import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan你要扫描那些组件 package   意味着托管了
@SpringBootApplication
//@ComponentScan("com.course.server") 你要扫描哪些组件，哪些包里面的类
@ComponentScan("com.course")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);


    }
}
