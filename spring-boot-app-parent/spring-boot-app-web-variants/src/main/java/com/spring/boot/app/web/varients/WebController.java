package com.spring.boot.app.web.varients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/web")
@Slf4j
public class WebController {

    @Value("${test.app.property1}")
    private String configprop;


    @GetMapping("hello")
    public String hello() {
        String currentPrincipalName = "DEFAULT!";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            currentPrincipalName = authentication.getName();
        }

        return "hey " + currentPrincipalName;
    }

    @GetMapping("/configprop")
    public String val(){
        return configprop;
    }
}
