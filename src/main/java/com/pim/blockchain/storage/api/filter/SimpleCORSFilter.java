package com.pim.blockchain.storage.api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {
	
	private final Log logger = LogFactory.getLog( this.getClass() );
	
	@Override
	public void init(FilterConfig fc) throws ServletException {
		logger.info("BlockchainStorage-API | SimpleCORSFilter loaded");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = ( HttpServletResponse ) res;
		HttpServletRequest request =  ( HttpServletRequest ) req;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		response.setHeader("Access-Control-Allow-Headers", "x-request-with, authorization, Content-Type, Authorization");
		response.setHeader("Access-Control-Max-Age", "3600");
		
		if("OPTIONS".equalsIgnoreCase( request.getMethod() )) {
			response.setStatus( HttpServletResponse.SC_OK );
			return;
		}
		chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		
	}
}
