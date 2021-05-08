package ru.vsu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.vsu")
@PropertySource("classpath:event.properties")
public class EventSpringConfig {

}
