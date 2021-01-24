package co.com.mercadolibre.articulos.controllers;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import co.com.mercadolibre.articulos.commons.dtos.ArticlePagesDto;
import co.com.mercadolibre.articulos.logic.services.Impl.ArticleServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticlesController.class)
@WithMockUser
public class ArticlesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleServicesImpl articleServices;

    ArticlePagesDto mockArticlesPages = new ArticlePagesDto(Arrays.asList(new ArticleDto("6007d5cc858d39001c60635a","Boeing making progress on Starliner software for test flight in March","https://spaceflightnow.com/2021/01/18/boeing-making-progress-on-starliner-software-for-test-flight-in-march/","https://mk0spaceflightnoa02a.kinstacdn.com/wp-content/uploads/2021/01/KSC-20210113-PH-BOE01_0002medium.jpg")),300);


    @Test
    public void getArticles() throws Exception {

        Mockito.when(articleServices.getArticlesFromApi(Mockito.anyInt(),
                                                        Mockito.anyInt())).thenReturn(mockArticlesPages);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v2/articles?pageSize=1&page=1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{ \"articles\": [{\"title\": \"Boeing making progress on Starliner software for test flight in March\",\"url\": \"https://spaceflightnow.com/2021/01/18/boeing-making-progress-on-starliner-software-for-test-flight-in-march/\",\"imageUrl\": \"https://mk0spaceflightnoa02a.kinstacdn.com/wp-content/uploads/2021/01/KSC-20210113-PH-BOE01_0002medium.jpg\"} ], \"totalPages\": 300 }";;

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}
