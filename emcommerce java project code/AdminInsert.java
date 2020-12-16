package com.company;

public class AdminInsert {

    private String categoryTitle;
    private String categoryDescription;

    private String productCategory;
    private String productTitle;
    private String productPrice;
    private String productQuantity;

    public AdminInsert(String categoryTitle, String categoryDescription) {
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public AdminInsert(String productCategory, String productTitle, String productPrice, String productQuantity) {
        this.productCategory = productCategory;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }


}
