package xin.tianchuang.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import xin.tianchuang.common.xss.XssFilter;

/**
 * Filter配置
 *
 * @author hui.deng
 * 
 * @date 2017-04-21 21:56
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<DelegatingFilterProxy> shiroFilterRegistration() {
		FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<DelegatingFilterProxy>();
		registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
		// 该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
		registration.addInitParameter("targetFilterLifecycle", "true");
		registration.setEnabled(true);
		registration.setOrder(Integer.MAX_VALUE - 1);
		registration.addUrlPatterns("/*");
		return registration;
	}

	@Bean
	public FilterRegistrationBean<XssFilter> xssFilterRegistration() {
		FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<XssFilter>();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns("/*");
		registration.setName("xssFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}
}
