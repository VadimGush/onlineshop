package net.thumbtack.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.thumbtack.onlineshop.controller.validation.RequiredName;
import net.thumbtack.onlineshop.database.models.Product;
import net.thumbtack.onlineshop.database.models.ProductCategory;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long id;
    @RequiredName
    private String name;
    @NotNull
    private Integer price;
    private Integer count = 0;
    private List<Long> categories;

    public ProductDto() {

    }

    public ProductDto(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public ProductDto(String name, int price, int count, List<Long> categories) {
        this(name, price, count);
        this.categories = categories;
    }

    public ProductDto(Product product, List<ProductCategory> categories) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.count = product.getCount();

        if (!categories.isEmpty()) {
            this.categories = new ArrayList<>();
            categories.forEach((category) -> this.categories.add(category.getCategory().getId()));
        }
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
