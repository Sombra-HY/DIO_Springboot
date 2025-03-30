package br.com.dio.controller;


import br.com.dio.entity.Produto;
import br.com.dio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @PostMapping(value = "/save")

    public ResponseEntity<Produto> saveProduct(@RequestBody Produto produto) throws Exception {
        produto = service.save(produto);
        return  ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> pega(@PathVariable Long id){
        return ResponseEntity.ok().body(
                service.findById(id)
        );
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Produto>> pegaall(){
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }



}
