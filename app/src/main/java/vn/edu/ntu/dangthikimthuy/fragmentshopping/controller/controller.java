package vn.edu.ntu.dangthikimthuy.fragmentshopping.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.dangthikimthuy.fragmentshopping.model.product;

public class controller extends Application implements icartcontroller  {
    List<product> listMH = new ArrayList<>();

    List<product> shoppingCart = new ArrayList<>();
    public controller(){

        listMH.add(new product("Khoai lang tím", 25000, "khoai lang Đà Lạt thơm ngon"));

        listMH.add(new product("Khoai tây", 25000, "khoai tây Ninh Hòa giàu dinh dưỡng"));

        listMH.add(new product("Khoai sọ", 25000, "khoai sọ thơm ngon"));

        listMH.add(new product("Cà Chua", 25000, "khoai chua Đà Lạt"));

    }




    public List<product> getAllList() {
        return null;
    }

    @Override
    public List<product> getListShoppingCart() {
        return null;
    }

    @Override
    public boolean addToCart(product p) {
        return false;
    }

    @Override
    public void addToListProduct(product product) {

    }

    @Override
    public void clearCart() {

    }
}
