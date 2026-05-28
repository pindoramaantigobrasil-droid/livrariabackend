package com.livraria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.backend.dto.LivroDTO;
import com.livraria.backend.entity.Livro;
import com.livraria.backend.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro cadastrarLivro(LivroDTO livroDTO) {

        Livro livro = new Livro();

        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setGenero(livroDTO.getGenero());
        livro.setPreco(livroDTO.getPreco());

        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, LivroDTO livroDTO) {

        Livro livro = livroRepository.findById(id).orElseThrow();

        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setGenero(livroDTO.getGenero());
        livro.setPreco(livroDTO.getPreco());

        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}