package com.carwash.cors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        // $NON-NLS-1$ //$NON-NLS-2$
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, OPTIONS, DELETE ,PUT");
        // $NON-NLS-1$//$NON-NLS-2$
        response.setHeader("Access-Control-Max-Age", "3600");
        // $NON-NLS-1$ //$NON-NLS-2$
        response.setHeader(
                "Access-Control-Allow-Headers",
                "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization"); //$NON-NLS-1$
        // $NON-NLS-1$
        chain.doFilter(req, res);
    }


    public void destroy() {

      //destroy
    }


    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {
    	//cors
    }

}
