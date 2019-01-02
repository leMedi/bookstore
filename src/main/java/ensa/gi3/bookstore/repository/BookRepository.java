package ensa.gi3.bookstore.repository;

import ensa.gi3.bookstore.model.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> {

}