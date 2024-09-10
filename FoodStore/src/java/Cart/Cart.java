/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Cart.CartItem;
import Product.ProductDAO;
import Product.ProductDAO;
import Product.ProductDAO;
import Product.ProductDTO;
import Product.ProductDTO;
import Product.ProductDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Cart extends ArrayList<CartItem>{
    public Cart(){
        super();
    }
    
    private CartItem search(String proId){
        for(CartItem product:this){
            if(product.getProductId().equals(proId))
                return product;
        }
        return null;
    }
    
    public boolean addToCart(String proId) throws SQLException, ClassNotFoundException{
        ProductDAO dao = new ProductDAO();
        ProductDTO product = dao.getProById(proId);
        CartItem item = search(proId);
        if(item!=null){
            item.setQuantity(item.getQuantity()+1);
//            item.setUnitPrice(item.getSubTotal());
        }
        else {
            this.add(new CartItem(proId, product.getProductName(), 1, product.getPrice(),product.getImage()));
        }
        return true;
    }
    
    public boolean removeFromCart(String proId){
        CartItem item = search(proId);
        if(item!=null){
            this.remove(item);
            return true;
        }
        return false;
    }
    
    public void removeAll(){
        this.clear();
    }
    
    public boolean updateCart(String proId,int quantity){
        CartItem item = search(proId);
        int index = this.indexOf(item);
        if(item!=null){
            CartItem updateItem = new CartItem(proId, item.getProductName(), quantity, item.getUnitPrice(),item.getImage());
            this.set(index, updateItem);
            return true;
        }
        return false;
    }
    
    
}
