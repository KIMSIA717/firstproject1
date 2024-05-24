package com.example.firstproject.api;

import com.example.firstproject.Service.ArticleService;
import com.example.firstproject.controller.ArticleController;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class ArticleApiController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;
    //GET
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }
    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        if(created != null){
            return ResponseEntity.status(HttpStatus.OK).body(created);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos);
        if(createdList != null){
            return ResponseEntity.status(HttpStatus.OK).body(createdList);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id,dto);
        if(updated != null){
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //DELETE
    @DeleteMapping("api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article deleted = articleService.delete(id);
        if(deleted != null){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
