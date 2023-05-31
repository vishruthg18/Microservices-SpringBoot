package com.vishruth.orderservice.service;

import com.vishruth.orderservice.DTO.OrderLineItemsDTO;
import com.vishruth.orderservice.DTO.OrderRequest;
import com.vishruth.orderservice.model.Order;
import com.vishruth.orderservice.model.OrderLineItems;
import com.vishruth.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {


    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDTOList()
                .stream().map(this::mapToDTO).toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        return orderLineItems;
    }
}
