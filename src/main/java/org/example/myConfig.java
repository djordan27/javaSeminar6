package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.example")
public class myConfig {
    @Scope("prototype")
    @Bean("notebook")
    public Notebook getNotebook(){
        return new Notebook();
    }
}
