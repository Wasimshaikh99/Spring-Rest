package com.wasim.customerdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

		@Override
		protected Class<?>[] getRootConfigClasses() {
			
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			
			System.out.println("success");
			return new Class[] { DemoAppConfig.class };
			
		}

		@Override
		protected String[] getServletMappings() {
			return new String[] { "/" };
		}

	}


