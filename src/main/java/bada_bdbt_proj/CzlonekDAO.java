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
public class CzlonekDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Czlonek> list(){
        String sql="SELECT * FROM PARTNERZY ORDER BY NR_PARTNERA";
        System.out.println(jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Czlonek.class)).isEmpty());
        List<Czlonek> listCzlonek=jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Czlonek.class));
        System.out.println("AAAA "+listCzlonek.size());
        return listCzlonek;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Czlonek czlonek) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PARTNERZY").usingColumns("NAZWA","STRONA_INTERNETOWA","SPOSOB_WSPOLPRACY","NR_KLUBU");
        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(czlonek);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Czlonek get(int id) {
        String sql = "SELECT * FROM PARTNERZY WHERE NR_PARTNERA = ?";
        Object[] args={id};
        Czlonek czlon=jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Czlonek.class));
        return czlon;
    }
    /* Update – aktualizacja danych */
    public void update(Czlonek czlonek) {
        String sql="UPDATE PARTNERZY SET NAZWA=:NAZWA,STRONA_INTERNETOWA=:STRONA_INTERNETOWA, SPOSOB_WSPOLPRACY=:SPOSOB_WSPOLPRACY,NR_KLUBU=:NR_KLUBU WHERE NR_PARTNERA=:NR_PARTNERA";
        BeanPropertySqlParameterSource param =new BeanPropertySqlParameterSource(czlonek);
        NamedParameterJdbcTemplate template =new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }
    public void delete(int id) {
        String sql="DELETE FROM PARTNERZY WHERE NR_PARTNERA=?";
        jdbcTemplate.update(sql,id);
    }

    public CzlonekDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
}
