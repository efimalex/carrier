package ru.carrier.web.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Created by efim on 08.07.14.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"ru.carrier.service","ru.carrier.repository","ru.carrier.web.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UrlBasedViewResolver configureUrlBasedViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(TilesView.class);
        urlBasedViewResolver.setOrder(1);
        return urlBasedViewResolver;
    }

    @Bean
    public TilesConfigurer configureTiles(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
            tilesConfigurer.setDefinitions("/WEB-INF/tiles/template.xml", "/WEB-INF/tiles/definitions.xml");

        return tilesConfigurer;
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource configureBundleMessageSource(){
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasenames("classpath:messages","classpath:application");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setFallbackToSystemLocale(false);
        return bundleMessageSource;
    }
//
//    @Bean
//    public CookieLocaleResolver configureLocaleResolver(){
//        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setDefaultLocale(Locale.US);
//        cookieLocaleResolver.setCookieName("myAppLocaleCookie");
//        cookieLocaleResolver.setCookieMaxAge(3600);
//        return cookieLocaleResolver;
//    }

    @Bean
    public MappingJackson2HttpMessageConverter configureJacksonHttpMessageConverter(){
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
       // messageConverter.setJsonPrefix("false");
        return messageConverter;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        registry.addInterceptor(localeChangeInterceptor);
    }
}
