package com.xiaozl.Test;


import com.xiaozl.dao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaozeli on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-ldap.xml"})
public class LdapOperationTest {

    private static Logger logger = LoggerFactory.getLogger(LdapOperationTest.class);

    @Resource
    PersonDao personDaoImpl;

    @Test
    /**
     * 启动的时候报密码错： [LDAP: error code 49 - Invalid Credentials]; nested exception is javax.naming.AuthenticationException: [LDAP: error code 49 - Invalid Credentials]
     * 有可能是你的密码真的错了，也有可能是，你的Contextsource中base和userdn没有写对
     *
     */
    public void SearchTest(){
        List a = personDaoImpl.getAllPersonNames();
        System.out.println("dfsas");
    }

    @Test
    public void SearchTest1(){
        boolean a = personDaoImpl.authenUser();
        System.out.println("dfsas");
    }
}
