package stc21.innopolis.university.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // /login -> будет загружаться login.html
    registry.addViewController("/login").setViewName("login");



  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
    registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
    registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
    registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
    registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/static/vendor/");

  }
  @Bean
  public NamedParameterJdbcTemplate getJdbcTemlpate(DataSource dataSource){
    return new NamedParameterJdbcTemplate(dataSource);
  }
}
