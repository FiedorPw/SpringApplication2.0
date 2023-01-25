package bada_bdbt_proj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CzlonekDAOTest extends Object {
    private CzlonekDAO dao;
    @BeforeEach
    void setUp() {
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BADAGRA09");
        datasource.setPassword("BADAGRA09");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao=new CzlonekDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        assertFalse(dao.list().isEmpty());
    }

    @Test
    void save() {
        Czlonek czlonek=new Czlonek(1,"korpo","korpo.com","Materialny",1);
        dao.save(czlonek);
    }

    @Test
    void get() {
        Czlonek czlon=dao.get(4);
        System.out.println(czlon);
    }

    @Test
    void update() {
        Czlonek czlon=new Czlonek();
        czlon.setNR_PARTNERA(10);
        czlon.setNAZWA("WykopPremium");
        czlon.setSPOSOB_WSPOLPRACY("Materialny");
        czlon.setSTRONA_INTERNETOWA("nu.wykop.pl");
        czlon.setNR_KLUBU(1);
        dao.update(czlon);
    }

    @Test
    void delete() {
        dao.delete(6);
    }

}