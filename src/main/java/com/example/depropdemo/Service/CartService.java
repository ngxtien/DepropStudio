package com.example.depropdemo.Service;

import com.example.depropdemo.Dao.CartItemRepository;
import com.example.depropdemo.Model.CartItem;
import com.example.depropdemo.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope

public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductsService productsService;

//    public void addProduct(Long productId, int quantity) {
//        Optional<Products> productOptional = productsService.getProductById(productId);
//        if (productOptional.isPresent()) {
//            Products product = productOptional.get();
//            CartItem cartItem = cartItemRepository.findByProducts_Id(productId)
//                    .orElse(new CartItem(null, null, product, 0, product.getPrice(), null, null));
//            cartItem.setQuantity(cartItem.getQuantity() + quantity);
//            cartItemRepository.save(cartItem);
//        }
//    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public void updateProductQuantity(Long productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByProducts_Id(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    public void removeProduct(Long productId) {
        CartItem cartItem = cartItemRepository.findByProducts_Id(productId)
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));
        cartItemRepository.delete(cartItem);
    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }

    public int getCartItemCount() {
        return cartItemRepository.findAll().stream().mapToInt(CartItem::getQuantity).sum();
    }
}
