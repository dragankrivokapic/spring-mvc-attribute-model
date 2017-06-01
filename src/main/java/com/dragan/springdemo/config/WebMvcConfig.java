package com.dragan.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.dragan.springdemo.interceptors.ExecutionTimerInterceptor;
import com.dragan.springdemo.interceptors.HeaderInterceptor;

@Configuration
@ComponentScan("com.dragan.springdemo")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private HeaderInterceptor headerInterceptor1;

    @Autowired
    private ExecutionTimerInterceptor executionTimerInterceptor;

    @Bean
    public DataSource dataSource() {
	final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
	dsLookup.setResourceRef(true);
	DataSource dataSource = dsLookup.getDataSource("jdbc/springdb");
	return dataSource;
    }

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
	UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setViewClass(JstlView.class);
	return resolver;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("testMvcHome");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(headerInterceptor1);
	registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
    }

}
