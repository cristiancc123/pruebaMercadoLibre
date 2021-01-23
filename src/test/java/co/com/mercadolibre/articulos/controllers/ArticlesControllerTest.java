package co.com.mercadolibre.articulos.controllers;

import co.com.mercadolibre.articulos.logic.services.Impl.ArticleServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticlesControllerTest {

    private ArticlesController articlesController;
    private ArticleServicesImpl articleServices;

    @Before
    public void setUp(){
        articleServices = Mockito.mock(ArticleServicesImpl.class);
        articlesController = new ArticlesController();
    }

    @Test
    @DisplayName(value = "Test 1 -> Resultado al pasar parametros correctos")
    public void test1(){

    }

    @Test
    @DisplayName(value = "Test 2 -> Resultado al pasar parametros con tipo de datos incorrectos")
    public void test2(){

    }

    @Test
    @DisplayName(value = "Test 3 -> Resultado al pasar parametros nulos")
    public void test3(){

    }

}
