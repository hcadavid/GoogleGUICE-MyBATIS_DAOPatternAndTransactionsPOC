package edu.eci.pdsw.sampleprj.basic;

import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.basic.dto.User;
import edu.eci.pdsw.sampleprj.basic.mapper.UserMapper;
import edu.eci.pdsw.sampleprj.basic.service.UserService;
import edu.eci.pdsw.sampleprj.basic.service.UserServiceImpl;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.guice.XMLMyBatisModule;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public class BasicSampleTest {

    private Injector injector;

    private UserService fooService;

    public static void main(String a[]) throws Exception{
        BasicSampleTest st=new BasicSampleTest();
        try{
        st.init();
        
        st.test();
        
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    
    @Before
    public void init() throws Exception {

        this.injector = createInjector(
                
                
                new XMLMyBatisModule() {

                    @Override
                    protected void initialize() {
                        install(JdbcHelper.MySQL);                        
                        setClassPathResource("mybatis-config.xml");
                        bind(UserService.class).to(UserServiceImpl.class);
                    }

                }
                
                /*new MyBatisModule() {
                    @Override
                    protected void initialize() {
                        install(JdbcHelper.MySQL);
                        bindDataSourceProviderType(PooledDataSourceProvider.class);
                        bindTransactionFactoryType(JdbcTransactionFactory.class);

                        
                        addMapperClass(UserMapper.class);

                        bindProperties(binder(), createTestProperties());
                        //bind(UserService.class).to(UserServiceImpl.class);
                    }

                }*/
        );
        this.fooService = this.injector.getInstance(UserService.class);
    }

    public static Properties createTestProperties() {
        
        
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.host", "desarrollo.is.escuelaing.edu.co");
        myBatisProperties.setProperty("JDBC.port", "3306");
        myBatisProperties.setProperty("JDBC.schema", "bdprueba");
        myBatisProperties.setProperty("JDBC.username", "bdprueba");
        myBatisProperties.setProperty("JDBC.password", "bdprueba");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }

    @Test
    public void test() {
        
        
        UserService fooService = injector.getInstance(UserService.class);
        System.out.println(fooService);
        
        //User user = fooService.doSomeBusinessStuff("2057000");
        fooService.addUser(new User(1223234,"aaaddda","xx55sasd22","asdasdas","asdasdas"));
        //System.out.println(user.getCodigo());
       //System.out.println(user.getNombre());
        
    }
}
