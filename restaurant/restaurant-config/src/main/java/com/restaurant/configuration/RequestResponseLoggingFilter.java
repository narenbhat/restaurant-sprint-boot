package com.restaurant.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RequestResponseLoggingFilter implements Filter {
	
	//private Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        //System.out.println("## Origin : " + request.getHeader("Origin"));
        //logger.info("## Origin : " + request.getHeader("Origin"));
        
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin")); 
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers","Access-Control-Allow-Methods,X-Auth-Token,X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
        
        //HttpServletRequest httpRequest = (HttpServletRequest) request;
        //Enumeration<String> headerNames = httpRequest.getHeaderNames();

        /*if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                        System.out.println("Header: " + httpRequest.getHeader(headerNames.nextElement()));
                }
        }

		/*
        String loginURI = request.getContextPath() + "/login";
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("currentUser") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
        /*if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }*/
        chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}