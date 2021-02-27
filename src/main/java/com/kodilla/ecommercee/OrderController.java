package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        System.out.println("These are all orders.");
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long OrderId) {
        return new OrderDto(1L, "Test order name.", true);
    }

    @PostMapping(value = "postOrder",consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestParam OrderDto orderDto) {
        return new OrderDto(1L, "Created test order name.", true);
    }

    @PutMapping(value = "updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestParam OrderDto orderDto) {
        return new OrderDto(1L, "Edited test order name.", true);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteTask(@RequestParam Long orderId) {
        System.out.println("Order has been canceled.");
    }
}
