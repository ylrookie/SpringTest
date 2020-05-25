package Spring.jdbcTemplate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.*;

public class testJdbcTemplate {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate npjt;
    private employeeDao employeeDao;

    @Before
    public void init(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = app.getBean("jdbcTemplate",JdbcTemplate.class);
        npjt = app.getBean("namedParameterJdbcTemplate",NamedParameterJdbcTemplate.class);
        employeeDao = app.getBean("employeeDao", Spring.jdbcTemplate.employeeDao.class);
    }
    /**
     * update() 增删改操作
     */
    @Test
    public void testUpdate(){
        String sql = "insert into tbl_employee(last_name,email,gender) value(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{"团团","kangyx@asiainfo.com",1});
    }

    /**
     * batchUpdate()  批量增删改
     */
    @Test
    public void testBatchUpdate(){
        String sql = "insert into tbl_employee(last_name,email,gender) value(?,?,?)";
        List<Object[]>  list = new ArrayList<Object[]>();
        list.add(new Object[]{"远远","aaaa",1});
        list.add(new Object[]{"媛媛","bbbb",1});
        jdbcTemplate.batchUpdate(sql,list);
    }

    @Test
    public void testBatchUpdateDelete(){
        String sql = "delete from tbl_employee where id = ?";
        List<Object[]>  list = new ArrayList<Object[]>();
        list.add(new Object[]{138});
        list.add(new Object[]{139});
        jdbcTemplate.batchUpdate(sql,list);
    }

    /**
     *queryForObject()
     *  1.查询单行数据，返回一个对象
     *  2.查询单值 返回单个值
     */
    @Test
    public void testQueryForObjectReturnObject(){
        String sql = "select id,last_name,email,gender from tbl_employee where id =?";
        //rowMapper 行映射，将结果集的一条数据映射成具体的一个java对象
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,137);
        System.out.println(employee);
    }
    @Test
    public void testQueryForObjectReturnValue(){
        String sql = "select count(1) from tbl_employee";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    /**
     * query() 查询多条数据返回多个对象的集合
     */
    @Test
    public void testQuery(){
        String sql = "select id,last_name,email,gender from tbl_employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> emps = jdbcTemplate.query(sql,rowMapper);
        Iterator<Employee> it = emps.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    /**
     * 测试具名参数模板类
     */
    @Test
    public void test(){
        String sql = "insert into tbl_employee(last_name,email,gender) value (:ln,:em,:ge)";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("ln","丑丑");
        map.put("em","cc.com");
        map.put("ge",0);
        npjt.update(sql,map);
    }

    @Test
    public void testNpjtObject() {
        //模拟Service层 直接传递给Dao层一个具体的  对象
        Employee employee = new Employee(null, "张无忌", "zwj@sina.com", 1);

        //在dao的插入方法中: 具名必须和对象的属性名一致
        String sql ="insert into tbl_employee(last_name,email,gender) values(:lastName,:email,:gender)";

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee) ;

        npjt.update(sql, paramSource);

    }
    /**
     * 测试employeeDao
     */
    @Test
    public void testEmployeeDao(){
        Employee employee = new Employee(null, "乔峰", "qf@sina.com", 1);

        employeeDao.insertEMployee(employee);
    }
}
