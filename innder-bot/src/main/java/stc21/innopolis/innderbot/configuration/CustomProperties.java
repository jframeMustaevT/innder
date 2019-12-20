package stc21.innopolis.innderbot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProperties {

    @Bean(name = "innderUrl")
    //todo исправить не работающий файл аппликейшон пропертиз
    public String innderUrl(@Value("http://localhost/api") String innderUrl){
        return innderUrl;
    }
}
