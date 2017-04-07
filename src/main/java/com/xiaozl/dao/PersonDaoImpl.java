package com.xiaozl.dao;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

/**
 * Created by xiaozeli on 2017/3/31.
 */
public class PersonDaoImpl implements PersonDao{

    private LdapTemplate ldapTemplate;

    public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    /**
     * [LDAP: error code 32 - No Such Object]; nested exception is javax.naming.NameNotFoundException:
     * [LDAP: error code 32 - No Such Object]; remaining name ''
     * 有可能是search方法参数 base 在ldap搜索的时候找不到，说明连接已经建立了。
     * @return
     */
    public List getAllPersonNames() {
        return ldapTemplate.search(
                "ou=users", "(objectClass=person)",
                new AttributesMapper() {
                    public Object mapFromAttributes(Attributes attrs)
                            throws NamingException {
                        return attrs.get("cn").get();
                    }
                });
    }

    public boolean authenUser() {
        try {
            ldapTemplate.getContextSource().getContext("uid=user1,ou=users,dc=xiaozl,dc=com","user1pwd");
            System.out.println("authentic success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
