package com.event.configuration.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.event.configuration.WebConfiguration;

public class SecurityBootstrap extends AbstractSecurityWebApplicationInitializer {
	public SecurityBootstrap() {
	     super(SecurityConfiguration.class,RESTAuthenticationEntryPoint.class,WebConfiguration.class);
	}
}
