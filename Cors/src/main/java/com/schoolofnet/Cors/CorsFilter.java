/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.Cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// CORS //
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, DELETE, GET, PATCH, OPTIONS");
		res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Origin");
		res.setHeader("Access-Control-Expose-Headers", "Authorization, Location");
		res.setHeader("Access-Control-Max-Age", "3600");
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

}
