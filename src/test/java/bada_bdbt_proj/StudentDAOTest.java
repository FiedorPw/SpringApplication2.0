package bada_bdbt_proj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest extends Object {
    private StudentDAO dao;
    @BeforeEach
    void setUp() throws SQLException {
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BADAGRB19");
        datasource.setPassword("BADAGRB19");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao=new StudentDAO(new JdbcTemplate(datasource));

        dao.list();


    }
    @Test
    void delete() {
        dao.delete(21);
    }

    @Test
    void connectionToDataBase() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@194.29.170.4:1521:xe", "BADAGRB19", "BADAGRB19");
        boolean reachable = conn.isValid(2);// 10 sec
        assertTrue(reachable);
    }

    @Test
    void list() {
        System.out.println(dao.list());
        assertFalse(dao.list().isEmpty());
    }

    @Test
    void save() {
        Student student=new Student(21,"stach","pach",12123,12);
        dao.save(student);
    }

    @Test
    void get() {
        Student stud=dao.get(4);
        System.out.println(stud);
    }

    @Test
    void simpleQueryTest() {
        Student student1 = dao.get(1);
        System.out.println(student1);

    }

    @Test
    void update() {
        Student czlon=new Student(1, "stach", "pach", 123123, 12);
        czlon.setID_STUDENTA(10);
        czlon.setIMIE("WykopPremium");
        czlon.setPESEL(1234);
        czlon.setNAZWISKO("nu.wykop.pl");
        czlon.setTELEFON(1);
        dao.update(czlon);
    }


}