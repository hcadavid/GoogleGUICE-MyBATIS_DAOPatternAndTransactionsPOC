package net.aomlab.samples.mybatisguice.multiple;

import com.google.inject.Injector;
import com.google.inject.PrivateModule;
import net.aomlab.samples.mybatisguice.basic.service.UserService;
import net.aomlab.samples.mybatisguice.multiple.dto.User;
import net.aomlab.samples.mybatisguice.multiple.dto.UserInfo;
import net.aomlab.samples.mybatisguice.multiple.mapper.UserInfoMapper;
import net.aomlab.samples.mybatisguice.multiple.mapper.UserMapper;
import net.aomlab.samples.mybatisguice.multiple.service.UserInfoService;
import net.aomlab.samples.mybatisguice.multiple.service.UserInfoServiceImpl;
import net.aomlab.samples.mybatisguice.multiple.service.UserServiceImpl;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Properties;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.bindProperties;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/12
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public class MultipleSampleTest {

    private Injector injector;

    private UserService userService;

    @Before
    public void init() throws Exception {

        this.injector = createInjector(
                new PrivateModule() {
                    @Override
                    protected void configure() {
                        install(new MyBatisModule() {
                            @Override
                            protected void initialize() {
                                install(JdbcHelper.MySQL);
                                bindDataSourceProviderType(PooledDataSourceProvider.class);
                                bindTransactionFactoryType(JdbcTransactionFactory.class);
                                addMapperClass(UserMapper.class);
                            }
                        });
                        bindProperties(binder(), createTestProperties());
                        bind(UserService.class).to(UserServiceImpl.class);
                        expose(UserService.class);
                    }
                },

                new PrivateModule() {
                    @Override
                    protected void configure() {
                        install(new MyBatisModule() {
                            @Override
                            protected void initialize() {
                                install(JdbcHelper.MySQL);
                                bindDataSourceProviderType(PooledDataSourceProvider.class);
                                bindTransactionFactoryType(JdbcTransactionFactory.class);
                                addMapperClass(UserInfoMapper.class);
                            }
                        });
                        bindProperties(binder(), createTestProperties2());
                        bind(UserInfoService.class).to(UserInfoServiceImpl.class);
                        expose(UserInfoService.class);
                    }
                }
        );
        this.userService = this.injector.getInstance(UserService.class);
    }

    public static Properties createTestProperties() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
        myBatisProperties.setProperty("JDBC.host", "localhost");
        myBatisProperties.setProperty("JDBC.port", "3306");
        myBatisProperties.setProperty("JDBC.schema", "test");
        myBatisProperties.setProperty("JDBC.username", "root");
        myBatisProperties.setProperty("JDBC.password", "");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }


    public static Properties createTestProperties2() {
        Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test2");
        myBatisProperties.setProperty("JDBC.host", "localhost");
        myBatisProperties.setProperty("JDBC.port", "3306");
        myBatisProperties.setProperty("JDBC.schema", "test2");
        myBatisProperties.setProperty("JDBC.username", "root");
        myBatisProperties.setProperty("JDBC.password", "");
        myBatisProperties.setProperty("JDBC.autoCommit", "false");
        return myBatisProperties;
    }

    @Test
    public void test() {
        UserService fooService = injector.getInstance(UserService.class);
        User user = (User) fooService.doSomeBusinessStuff("1");

        UserInfoService userInfoService = injector.getInstance(UserInfoService.class);

        UserInfo userInfo = null;
        try {
            userInfo = userInfoService.getUserInfo("1");
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        System.out.println(user.getUserId());
        System.out.println(user.getName());

        System.out.println(userInfo.getUserId());
        System.out.println(userInfo.getAddress());
    }
}
