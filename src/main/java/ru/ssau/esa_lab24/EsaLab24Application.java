package ru.ssau.esa_lab24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@SpringBootApplication
public class EsaLab24Application {
    @Bean
    public ViewResolver getXSLTViewResolver() {

        XsltViewResolver xsltResolver = new XsltViewResolver();
        xsltResolver.setOrder(1);

        xsltResolver.setViewClass(XsltView.class);
        xsltResolver.setViewNames("categories", "orders");
        xsltResolver.setPrefix("/WEB-INF/xsl/");
        xsltResolver.setSuffix(".xsl");

        return xsltResolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(EsaLab24Application.class, args);
    }

}
