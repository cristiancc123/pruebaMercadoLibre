package co.com.mercadolibre.articulos.controllers;

import co.com.mercadolibre.articulos.commons.dtos.ArticleDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArticlesController {

    public ResponseEntity<?> getArticles();

}
