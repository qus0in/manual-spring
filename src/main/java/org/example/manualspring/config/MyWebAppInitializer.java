package org.example.manualspring.config;

import jakarta.servlet.*;
import org.example.manualspring.filter.EncodingFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.EnumSet;

public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // @ -> 이걸 기준으로 스프링을 운용
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        // DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        // EncodingFilter 등록
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter(
                "encodingFilter",
                new EncodingFilter()
        );
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
    }
}
