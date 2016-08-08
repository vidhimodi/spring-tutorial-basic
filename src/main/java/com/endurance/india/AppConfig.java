package com.endurance.india;

import com.endurance.india.aspects.MethodCallTracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.endurance.india")
public class AppConfig {

    @Bean
    public MethodCallTracer callTracer(){
        return new MethodCallTracer();
    }

}