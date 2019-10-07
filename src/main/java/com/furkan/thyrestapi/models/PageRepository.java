package com.furkan.thyrestapi.models;

import java.util.List;
import java.util.Optional;

import com.furkan.thyrestapi.models.data.Page;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

/**
 * PageRepository
 */
/*public interface PageRepository extends CrudRepository<Page, Integer>{
    @Override
    List<Page> findAll(); 
}*/
public interface PageRepository extends JpaRepository<Page, Integer>{

    Optional<Page> findBySlug(String slug);

    //@Query("SELECT p FROM Page p WHERE p.id != :id and p.slug != :slug")
    //Page findBySlug(int id, String slug);

    Page findBySlugAndIdNot(String slug, int id);

    List<Page> findAllByOrderBySortingAsc();
}