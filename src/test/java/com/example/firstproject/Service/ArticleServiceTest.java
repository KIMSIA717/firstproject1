package com.example.firstproject.Service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        List<Article> articles = articleService.index();
        Article a = new Article(1L,"가가가가","1111");
        Article b = new Article(2L,"나나나나","2222");
        Article c = new Article(3L,"다다다다","3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    void show() {
        Long id = 1L;
        Article expected = new Article(id,"가가가가","1111");
        Article article = articleService.show(id);
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    @Transactional
    void create() {
        String title = "라라라라";
        String content ="4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L,title,content);
        Article article = articleService.create(dto);
        assertEquals(expected.toString(),article.toString());

    }

    @Test
    @Transactional
    void update() {
        String title = "rtsetsdf";
        String content ="1555";
        ArticleForm dto = new ArticleForm(1L,title,content);
        Article expected = new Article(1L,title,content);
        Article article = articleService.update(1L,dto);
        assertEquals(expected.toString(),article.toString());
    }
    //githubTest
    @Test
    @Transactional
    void delete() {
        Article expected = new Article(1L,"가가가가","1111");
        Article article = articleService.delete(1L);
        assertEquals(expected.toString(),article.toString());
    }
}