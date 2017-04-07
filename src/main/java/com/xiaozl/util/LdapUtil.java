package com.xiaozl.util;

import org.springframework.ldap.core.AuthenticationSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * Created by xiaozeli on 2017/3/31.
 */
public class LdapUtil {

    public static LdapTemplate getLdapTemplate(){
        LdapContextSource cs = new LdapContextSource();
        cs.setCacheEnvironmentProperties(false);
        cs.setUrl("ldap://10.94.221.63:389");
        cs.setBase("dc=xiaozl,dc=com");
        cs.setUserDn("cn=Manager");
        cs.setPassword("secret");
        cs.setAuthenticationSource(new AuthenticationSource() {
            /**
             * 返回的是密码信息
             * @return
             */
            public String getPrincipal() {
                return "user1pwd";
            }

            /**
             * 返回的是账号信息
             * @return
             */
            public String getCredentials() {
                return "uid=user1";
            }
        });
        return new LdapTemplate(cs);
    }

}
