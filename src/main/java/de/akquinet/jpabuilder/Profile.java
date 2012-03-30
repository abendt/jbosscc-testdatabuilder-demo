package de.akquinet.jpabuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Profile { 
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Long id; 
 
   @Column(nullable = false) 
   private String language; 
 
   // Getters and setters 
} 