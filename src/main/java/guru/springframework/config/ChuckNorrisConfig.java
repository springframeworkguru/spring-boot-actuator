package guru.springframework.config;

import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jt on 12/27/16.
 */
@Configuration
public class ChuckNorrisConfig {
    @Bean
    public ChuckNorrisInfoContributor chuckNorrisInfoContributor(){
        return new ChuckNorrisInfoContributor();
    }

}
