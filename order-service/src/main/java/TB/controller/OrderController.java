package TB.controller;

import TB.dto.OrderRequestDto;
import TB.entity.PurchaseOrder;
import TB.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    PurchaseOrder placeAnOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping
    List<PurchaseOrder> getOrdersPlaced() {
        return orderService.getAllOrders();
    }
}
