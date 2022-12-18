package com.bvk.bvkjavaspringboot.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {

    @NotNull(message = "user_id is required")
    private Long user_id;
    @NotNull(message = "product_id is required")
    private Long product_id;
    @NotNull(message = "quaniity is required")
    private Integer quantity;

}
