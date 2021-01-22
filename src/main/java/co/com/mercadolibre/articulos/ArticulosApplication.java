package co.com.mercadolibre.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArticulosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticulosApplication.class, args);
    }

}
