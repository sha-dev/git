package jp.co.loggerSample;

import javax.servlet.Filter;

import jp.co.loggerSample.filter.AccessLogFilter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public Filter LogFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        
        return new AccessLogFilter();
    }
}
