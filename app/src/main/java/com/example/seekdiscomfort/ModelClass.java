package com.example.seekdiscomfort;

public class ModelClass {

    private int product_imageview;
    private String product_name;
    private String product_price;
    private String product_des;

    ModelClass(int product_imageview, String product_name, String product_price, String product_des){
        this.product_imageview = product_imageview;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_des = product_des;
    }
    public int getProduct_imageview() {
        return product_imageview;
    }

    public void setProduct_imageview(int product_imageview) {
        this.product_imageview = product_imageview;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_des() {
        return product_des;
    }

    public void setProduct_des(String product_des) {
        this.product_des = product_des;
    }
}
