package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@Import(OtherConfig.class)
public class BeansConfig {
    @Bean
    public BeanA myBeanA() {
        return new BeanA();
    }

    @Bean(initMethod = "bInitMethod", destroyMethod = "bDestroyMethod")
    @DependsOn("myBeanD")
    public BeanB myBeanB() {
        return new BeanB();
    }

    @Bean(initMethod = "cInitMethod", destroyMethod = "cDestroyMethod")
    @DependsOn({"myBeanD", "myBeanB"})
    public BeanC myBeanC() {
        return new BeanC();
    }

    @Bean(initMethod = "dInitMethod", destroyMethod = "dDestroyMethod")
    public BeanD myBeanD() {
        return new BeanD();
    }

    @Bean
    public BeanE myBeanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF myBeanF() {
        return new BeanF();
    }
}
