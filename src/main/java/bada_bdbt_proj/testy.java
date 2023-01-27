package bada_bdbt_proj;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class testy {
    public static void main (String  args[]){
        StudentDAO dao;
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BADAGRB19");
        datasource.setPassword("BADAGRB19");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao=new StudentDAO(new JdbcTemplate(datasource));

        dao.list();
    }


}
