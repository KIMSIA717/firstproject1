package com.example.firstproject.api;

import com.example.firstproject.Service.ArticleService;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleApiControllerTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        List<Article> aricles = articleService.index();
        Article a = new Article(1L,"가가가가","1111");
        Article b = new Article(2L,"sdgsdg","2222");
        Article c = new Article(3L,"ekekek","3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        assertEquals(expected.toString(),aricles.toString());

    }

    @Test
    void testIndex() {
    }
}