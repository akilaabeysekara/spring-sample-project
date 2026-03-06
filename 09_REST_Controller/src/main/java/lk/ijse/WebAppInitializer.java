package lk.ijse;

import lk.ijse.config.WebAppConfig;
import lk.ijse.config.WebRootConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class<?>[]{WebRootConfig.class};
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     * Enable multipart/form-data support for DispatcherServlet
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(
                        null,        // upload directory
                        5242880,     // max file size (5MB)
                        10485760,    // max request size (10MB)
                        0 // file size threshold in bytes - 0 means all files are written directly to disk
                );

        registration.setMultipartConfig(multipartConfigElement);
    }
}