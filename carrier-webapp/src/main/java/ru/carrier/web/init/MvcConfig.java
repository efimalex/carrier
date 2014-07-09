package ru.carrier.web.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Created by efim on 08.07.14.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.carrier.web")
public class MvcConfig {

    @Bean
    public UrlBasedViewResolver configureUrlBasedViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(TilesView.class);
        urlBasedViewResolver.setOrder(1);
        return urlBasedViewResolver;
    }

//    @Bean
//    public ResourceBundleViewResolver configureResourceBundleViewResolver(){
//        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
//        viewResolver.setBasename("views");
//        return viewResolver;
//    }

    @Bean
    public TilesConfigurer configureTiles(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
            tilesConfigurer.setDefinitions("/WEB-INF/tiles/template.xml", "/WEB-INF/tiles/definitions.xml");

        return tilesConfigurer;
    }


}
