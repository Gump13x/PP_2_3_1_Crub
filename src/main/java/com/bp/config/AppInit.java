package com.bp.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		registerHiddenFieldFilter(servletContext);
	}

	public void registerHiddenFieldFilter(ServletContext servletContext) {
		servletContext
				.addFilter("hiddenHttpMethodFilter",
						new HiddenHttpMethodFilter())
				.addMappingForUrlPatterns(null, true, "/*");
	}

	private void registerCharacterEncodingFilter(ServletContext aContext) {
		EnumSet<DispatcherType> dispatcherTypes = EnumSet
				.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		FilterRegistration.Dynamic characterEncoding = aContext
				.addFilter("characterEncoding", characterEncodingFilter);
		characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
	}
}
