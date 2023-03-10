package bada_bdbt_proj;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String args[])
    {
        SpringApplication.run(Application.class, args);
    }

}
