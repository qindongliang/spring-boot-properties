package com.qdl.demo.controller;

import com.qdl.demo.conf.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by QinDongLiang on 2017/10/28.
 */
@Controller
public class DemoController {

    @Autowired
    private ConfigProperties configProperties;


    @RequestMapping("test")
    @ResponseBody
    public String hello(){

        StringBuffer sb=new StringBuffer();

        sb.append("==============简单属性访问================<br/>");
        //简单属性的访问
        sb.append(configProperties.getFrom()+"<br/>");
        sb.append(configProperties.getHost()+"<br/>");
        sb.append(configProperties.getPort()+"<br/>");

        sb.append("==============List[String]访问================"+"<br/>");
        sb.append(configProperties.getRecipients()+"<br/><br/>");
        sb.append("==============Map[String,String]访问================"+"<br/>");
        sb.append(configProperties.getAdditionalHeaders()+"<br/><br/>");

        sb.append("==============Object访问================"+"<br/>");

        sb.append(configProperties.getCredentials()+"<br/><br/>");

        sb.append("==============List[Object]访问================<br/>");
        for(ConfigProperties.Credentials cs:configProperties.getCs()){
            sb.append(cs+"<br/>");
        }
        sb.append("<br/>==============Map[String,Object]访问================"+"<br/>");
        for(Map.Entry<String,ConfigProperties.Credentials> me:configProperties.getMp().entrySet()){
            sb.append(me.getKey()+"    "+me.getValue()+"<br/>");
        }

        sb.append("（注意不支持Set属性） ");

        return sb.toString();
    }



}
