package vn.edu.ntu.dangthikimthuy.fragmentshopping.controller;

import java.util.List;

import vn.edu.ntu.dangthikimthuy.fragmentshopping.model.product;

public interface icartcontroller {
    public List<product> getAllList();



    //mảng ds các mặt hàng trong giỏ

    public List<product> getListShoppingCart();



    //Kiểm tra mặt hàng có nằm trong giỏ hàng chưa

    public boolean addToCart(product p);



    public  void addToListProduct(product product);



    //Xóa giỏ hàng

    public void clearCart();
}
