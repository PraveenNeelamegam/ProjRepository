package com.deloitte.cofiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deloitte.handler.KrogerFilter;

@Configuration
public class KrogerConfiguration {
	
	@Autowired
	private KrogerFilter jwtfilter;
	
	@Bean
	public FilterRegistrationBean<KrogerFilter> filterRegistrationBean(){
		FilterRegistrationBean<KrogerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(jwtfilter);
		filterRegistrationBean.addUrlPatterns("/secured/*");
		return filterRegistrationBean;
	}
}
