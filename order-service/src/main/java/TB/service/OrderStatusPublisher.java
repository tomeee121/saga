package TB.service;

import TB.dto.OrderRequestDto;
import TB.event.OrderEvent;
import TB.event.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
@AllArgsConstructor
public class OrderStatusPublisher {

    private Sinks.Many<OrderEvent> orderSinks;

    public void publishOrderEventDto(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        OrderEvent orderEvent = new OrderEvent(orderRequestDto, orderStatus);
        orderSinks.tryEmitNext(orderEvent);
    }
}
