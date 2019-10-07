package com.furkan.thyrestapi.models.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Page
 */
@Entity
@Table(name="pages")
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=2, message = "Title must be at least 2 characters long")
    private String title;

    private String slug;

    @Size(min=5, message = "Title must be at least 5 characters long")

    private String content;

    private int sorting;
    
}