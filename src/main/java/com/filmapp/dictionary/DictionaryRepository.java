package com.filmapp.dictionary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface DictionaryRepository<T extends Dictionary> extends JpaRepository<T, Long> {
    List<T> findByOrderByIdAsc();
    boolean existsByName(String name);
}
