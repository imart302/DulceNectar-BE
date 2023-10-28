package com.dulcenectar.java.repositories;
import org.springframework.data.repository.CrudRepository;
import com.dulcenectar.java.models.Category;

public interface CategoriesRepository extends CrudRepository<Category, Integer>{

}
