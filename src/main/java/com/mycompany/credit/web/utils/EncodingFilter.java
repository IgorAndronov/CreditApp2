package com.mycompany.credit.web.utils;


import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class EncodingFilter  implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("!!!!!!!!!!!!!!Encoding");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);

    }


    public void destroy() {
        // TODO Auto-generated method stub

    }

}