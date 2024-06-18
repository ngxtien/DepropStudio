package com.example.depropdemo.Controller;

import com.example.depropdemo.Model.CartItem;
import com.example.depropdemo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long productId, @RequestParam int quantity ) {
        cartService.addProduct(productId, quantity);
        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", cartItems.stream().mapToDouble(item -> item.getUnitPrice() * item.getQuantity()).sum());
        return "Test/cart";
    }

    @PostMapping("/cart/update/{productId}")
    public String updateProductQuantity(@PathVariable Long productId, @RequestParam int quantity) {
        cartService.updateProductQuantity(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{productId}")
    public String removeProductFromCart(@PathVariable Long productId) {
        cartService.removeProduct(productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @GetMapping("/cart/count")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getCartItemCount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("count", cartService.getCartItemCount());
        return ResponseEntity.ok(response);
    }
}
