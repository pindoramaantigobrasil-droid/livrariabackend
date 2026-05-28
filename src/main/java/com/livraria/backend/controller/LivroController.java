package com.livraria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.backend.dto.LivroDTO;
import com.livraria.backend.entity.Livro;
import com.livraria.backend.service.LivroService;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "http://localhost:5173")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        return livroService.cadastrarLivro(livroDTO);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(
            @PathVariable Long id,
            @RequestBody LivroDTO livroDTO) {

        return livroService.atualizarLivro(id, livroDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}