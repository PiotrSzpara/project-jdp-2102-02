
package com.kodilla.ecommercee.domain;

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