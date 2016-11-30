package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;
/**
 * Created by Gaming I5 PC on 30/11/2016.
 */
@Entity
public class Category extends Model{

    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @OneToMany
    private List<Product> products;

    public Category() {
    }

    public Category(Long id, String name, List<Product> products) {
        this.setId(id);
        this.setName(name);
        this.setProducts(products);
    }

    public static Finder<Long, Category> find = new Finder<Long, Category>(Category.class);

    public static List<Category> findAll() {
        return Category.find.where().orderBy("name asc").findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
