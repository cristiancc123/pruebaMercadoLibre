package co.com.mercadolibre.articulos;

import co.com.mercadolibre.articulos.controllers.ArticlesController;
import co.com.mercadolibre.articulos.logic.gateways.IArticlesGateway;
import co.com.mercadolibre.articulos.logic.services.Impl.ArticleServicesImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticulosApplicationTests {

    @Autowired
    private ArticlesController articlesController;

    @Autowired
    private ArticleServicesImpl articleServices;

    @Autowired
    private IArticlesGateway articlesGateway;

    @Test
    void contextLoads() {
        assertThat(articlesController).isNotNull();
        assertThat(articleServices).isNotNull();
        assertThat(articlesGateway).isNotNull();
    }

}
