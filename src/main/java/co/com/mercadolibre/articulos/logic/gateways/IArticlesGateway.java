package co.com.mercadolibre.articulos.logic.gateways;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArticlesGateway {

    public List<ArticleDto> getArticlesApiSpaceflight();

}
