package bada_bdbt_proj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class Test2 extends Object {


    private CzlonekDAO dao;

    @BeforeEach
    void setUp() throws SQLException {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BADAGRB19");
        datasource.setPassword("BADAGRB19");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao = new CzlonekDAO(new JdbcTemplate(datasource));

        //dao.list();


    }

    @Test
    void connectionToDataBase() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@194.29.170.4:1521:xe", "BADAGRB19", "BADAGRB19");
        boolean reachable = conn.isValid(4);// 10 sec
        assertTrue(reachable);
    }

    @Test
    void list() {
        System.out.println(dao.list());
        assertFalse(dao.list().isEmpty());
    }


}