package TB.service;

import TB.dto.OrderRequestDto;
import TB.entity.PurchaseOrder;
import TB.event.OrderStatus;
import TB.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static TB.event.OrderStatus.ORDER_CREATED;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusPublisher orderStatusPublisher;

    @Transactional(Transactional.TxType.REQUIRED)
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder orderPlaced = orderRepository.saveAndFlush(convertOrderDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(orderPlaced.getId());
        orderStatusPublisher.publishOrderEventDto(orderRequestDto, ORDER_CREATED);
        return orderPlaced;
    }

    private PurchaseOrder convertOrderDtoToEntity(OrderRequestDto orderRequestDto) {
        return new PurchaseOrder(orderRequestDto.getOrderId(), orderRequestDto.getUserId(), orderRequestDto.getProductId(),
                orderRequestDto.getAmount(), ORDER_CREATED, null);
    }

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
