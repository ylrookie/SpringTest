package Spring.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class employeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate npjt;

    public void insertEMployee(Employee employee){
        String sql = "insert into tbl_employee(last_name,email,gender) value(:lastName,:email,:gender)";
        SqlParameterSource sps = new BeanPropertySqlParameterSource(employee);
        npjt.update(sql,sps);

    }
}
