package com.raul.block5profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Profile("PRODUCTION")
public class PRODUCTION{

    @Value("${spring.profiles.active}")
    private String perfilActivo;

    @Value("${bd.url}")
    private String enlace;

    @Bean
    CommandLineRunner ejecutarProduccion(){
        return args -> {
            System.out.println("Hola desde el perfil de " + perfilActivo);

            System.out.println("EL enlace a la base de datos es la siguiente: " + enlace);
        };
    }


}
