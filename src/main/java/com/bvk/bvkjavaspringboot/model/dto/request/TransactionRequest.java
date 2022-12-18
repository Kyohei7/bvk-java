package com.bvk.bvkjavaspringboot.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    @NotNull(message = "cart_id is required")
    private Long cart_id;

    @NotNull(message = "user_id is required")
    private Long user_id;

}
