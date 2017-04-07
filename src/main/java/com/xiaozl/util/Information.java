package com.xiaozl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xiaozeli on 2017/3/31.
 */
public class Information {

    static private Information instance;

    private Information() {
        // TODO Auto-generated constructor stub
    }

    static public Information getInstance() {
        if(instance == null)
            instance = new Information();
        return instance;
    }

    public String getErrorInfo(int errorCode) {
        Properties properties = new Properties();
        InputStream in = this.getClass().getResourceAsStream("/config.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties.getProperty(errorCode + "", "null");
    }

    public String getConfigInfo(String param){
        Properties properties = new Properties();
        InputStream in = this.getClass().getResourceAsStream("/config.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties.getProperty(param, "null");
    }
}
