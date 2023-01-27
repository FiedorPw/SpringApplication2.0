package bada_bdbt_proj;
import java.util.List;


import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


@Repository
public class StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Student> list(){
        String sql="SELECT * FROM STUDENCI";

        System.out.println(jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Student.class)).isEmpty());
        List<Student> listStudent=jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Student.class));
        System.out.println(listStudent);
        return listStudent;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Student student) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("STUDENCI").usingColumns("ID_STUDENTA","IMIE","NAZWISKO","PESEL","TELEFON");
        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(student);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Student get(int id) {
        String sql = "SELECT * FROM STUDENCI WHERE ID_STUDENTA = ?";

        Object[] args={id};
        Student stud=jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Student.class));
        return stud;

    }





    /* Update – aktualizacja danych */
    public void update(Student student) {
        String sql="UPDATE STUDENCI SET ID_STUDENTA=:ID_STUDENTA,IMIE=:IMIE, NAZWISKO=:NAZWISKO,PESEL=:PESEL,TELEFON=:TELEFON WHERE ID_STUDENTA=:ID_STUDENTA";
//        String sql="UPDATE PARTNERZY SET NAZWA=:NAZWA,STRONA_INTERNETOWA=:STRONA_INTERNETOWA, SPOSOB_WSPOLPRACY=:SPOSOB_WSPOLPRACY,NR_KLUBU=:NR_KLUBU WHERE NR_PARTNERA=:NR_PARTNERA";

        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(student);
        NamedParameterJdbcTemplate template =new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }
    public void delete(int id) {
        String sql="DELETE FROM STUDENCI WHERE ID_STUDENTA =?";
        jdbcTemplate.update(sql,id);
    }

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
}
