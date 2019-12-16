package stc21.innopolis.university.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("stc21.innopolis.university")
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    /*
     * STEP 1 - Create SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    /*
     * STEP 2 - Create SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /*
     * STEP 3 - Register ThymeleafViewResolver
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
////        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //registry.addViewController("/").setViewName("index");
//    }
//
//    @Bean
//    public InternalResourceViewResolver setupViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        //resolver.setViewClass(JstlView.class);
//
//        return resolver;
//    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver =
//            new InternalResourceViewResolver("/webapp/views/", ".html");
//        registry.viewResolver(viewResolver);
//        //UrlBasedViewResolverRegistration jsp = registry.jsp("/webapp/views/", ".html");
//
//        //System.out.println(jsp.viewNames());
//    }

//  @Bean
//  public InternalResourceViewResolver internalResourceViewResolver(){
//    InternalResourceViewResolver viewResolver =
//            new InternalResourceViewResolver("/views/", ".html");
//    return viewResolver;
//  }




}
