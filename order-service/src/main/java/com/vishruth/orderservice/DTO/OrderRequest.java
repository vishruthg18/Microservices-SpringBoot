package com.vishruth.orderservice.DTO;

import com.vishruth.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private List<OrderLineItemsDTO> orderLineItemsDTOList;
}
