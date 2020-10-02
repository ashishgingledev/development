package com.ingleash.non.spring.boot.app;
import com.ingleash.non.spring.boot.app.beans.TestBean;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;
import org.springframework.core.io.*;

public class MainAPpClass {
    public static void main(String[] args) {
        Resource resource=new ClassPathResource("spring-conf/applicationContext.xml");
        BeanFactory factory=new XmlBeanFactory(resource);

        TestBean student=(TestBean)factory.getBean("mytestBean");
        System.out.print(student.getName());
        System.out.print(student.add());
        System.out.print(student.getOneMore().getA());
    }
}
