package bada_bdbt_proj;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class CzlonkowieManager {
    public static void main(String args[])
    {
        SpringApplication.run(CzlonkowieManager.class, args);
    }

}
