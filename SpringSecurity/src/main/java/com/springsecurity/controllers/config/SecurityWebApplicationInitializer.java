package com.springsecurity.controllers.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {}
