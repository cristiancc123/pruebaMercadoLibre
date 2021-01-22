package co.com.mercadolibre.articulos.logic.services;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;

import java.util.List;

public interface IArticlesServices {

    public List<ArticleDto> getArticlesFromApi();

}
