package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@Import(OtherConfig.class)
public class BeansConfig {
    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean(initMethod = "bInitMethod", destroyMethod = "bDestroyMethod")
    @DependsOn("getBeanD")
    public BeanB getBeanB() {
        return new BeanB();
    }

    @Bean(initMethod = "cInitMethod", destroyMethod = "cDestroyMethod")
    @DependsOn({"getBeanD", "getBeanB"})
    public BeanC getBeanC() {
        return new BeanC();
    }

    @Bean(initMethod = "dInitMethod", destroyMethod = "dDestroyMethod")
    public BeanD getBeanD() {
        return new BeanD();
    }

    @Bean
    public BeanE getBeanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF getBeanF() {
        return new BeanF();
    }
}
