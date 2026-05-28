package com.livraria.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.livraria.backend.entity.Livro;
import com.livraria.backend.repository.LivroRepository;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(LivroRepository livroRepository) {
        return args -> {

            livroRepository.deleteAll();

            livroRepository.save(new Livro(null, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 39.90));
            livroRepository.save(new Livro(null, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", 45.50));
            livroRepository.save(new Livro(null, "Dom Casmurro", "Machado de Assis", "Romance", 29.90));
            livroRepository.save(new Livro(null, "1984", "George Orwell", "Ficcao", 34.99));
            livroRepository.save(new Livro(null, "Drácula", "Bram Stoker", "Terror", 42.00));
            livroRepository.save(new Livro(null, "Percy Jackson", "Rick Riordan", "Aventura", 37.80));
            livroRepository.save(new Livro(null, "Jogos Vorazes", "Suzanne Collins", "Ficcao", 41.20));
            livroRepository.save(new Livro(null, "A Cabana", "William P. Young", "Drama", 32.50));
            livroRepository.save(new Livro(null, "Clean Code", "Robert C. Martin", "Tecnologia", 89.90));
            livroRepository.save(new Livro(null, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Romance", 24.90));

            
        };
    }
}