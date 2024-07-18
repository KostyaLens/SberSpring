package org.example.emptity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    private long id;
    private List<Product> productList;
    private String promoCode;
}