package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Models.DTO.ProductWithQuantityDto;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Persistence.Entities.CartItemId;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartItemRepo extends GenericRepo<CartItem, CartItemId>{
    public CartItemRepo(EntityManager entityManager) {super(CartItem.class , entityManager);}

    public void deleteItemByCartIdAndProductId(Integer cartId,Integer productId){
        Query query = entityManager.createQuery("DELETE  FROM CartItem c WHERE c.cart.id = :cartId and c.product.id = :productId");
        query.setParameter("cartId", cartId);
        query.setParameter("productId", productId);
        query.executeUpdate();
    }

    public  List<ProductWithQuantityDto> retrieveCartItemNotExistInLocalStorageRepo(int cartId, Integer[] productIdsArray) {
        // Constructing the JPQL query
        String jpql = "SELECT ci FROM CartItem ci " +
                "WHERE ci.cart.id = :cartId";
        // Creating the query
        List<Integer> productIdsList = Arrays.asList(productIdsArray);

        TypedQuery<CartItem> query = entityManager.createQuery(jpql, CartItem.class);
        query.setParameter("cartId", cartId);

        List<CartItem> cartItems = query.getResultList().stream().filter(cartItem -> !productIdsList.contains(cartItem.getId().getProductId())).toList();
        List<ProductWithQuantityDto> productWithQuantityDtoList = new ArrayList<>();

        // Extracting products from cartItems
        List<Product> products = cartItems.stream()
                .map(CartItem::getProduct)
                .toList();
        for (int i = 0; i < products.size(); i++) {
            productWithQuantityDtoList.add(new ProductWithQuantityDto(products.get(i).getId(),products.get(i).getProductName(),
                    products.get(i).getProductPrice(), products.get(i).getProductDescription(),
                    products.get(i).getProductImages().get(0).getImageUrl(),cartItems.get(i).getQuantity()));        }


        return productWithQuantityDtoList;
    }
    public  List<ProductWithQuantityDto> retrieveProductWithQuantityDtoRepo(int cartId) {
        // Constructing the JPQL query
        String jpql = "SELECT ci FROM CartItem ci " +
                "WHERE ci.cart.id = :cartId";
        // Creating the query

        TypedQuery<CartItem> query = entityManager.createQuery(jpql, CartItem.class);
        query.setParameter("cartId", cartId);

        List<CartItem> cartItems = query.getResultList();


        List<ProductWithQuantityDto> productWithQuantityDtoList = new ArrayList<>();
        // Extracting products from cartItems
//        cartItems.get(0).getId().getProductId();
        List<Product> products = cartItems.stream()
                .map(CartItem::getProduct)
                .toList();
        for (int i = 0; i < products.size(); i++) {
            productWithQuantityDtoList.add(new ProductWithQuantityDto(products.get(i).getId(),products.get(i).getProductName(),
                    products.get(i).getProductPrice(), products.get(i).getProductDescription(),
                    products.get(i).getProductImages().get(0).getImageUrl(),cartItems.get(i).getQuantity()));
        }
        return productWithQuantityDtoList;
    }

}
