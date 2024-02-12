package TB.config;

import TB.event.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class OrderConfiguration {

    @Bean
    public Sinks.Many<OrderEvent> orderSinks() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<OrderEvent>> orderSupplier(Sinks.Many<OrderEvent> orderSinks) {
        return orderSinks::asFlux;
    }
}
