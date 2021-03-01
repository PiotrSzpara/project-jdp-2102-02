
package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    int productId;
    String productName;
    int productPrice;
    String productDescription;
}