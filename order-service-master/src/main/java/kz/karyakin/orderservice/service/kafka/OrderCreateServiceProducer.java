package kz.karyakin.orderservice.service.kafka;

import kz.karyakin.orderservice.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreateServiceProducer {

    private static final String TOPIC = "restaurant-events";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void mealQuantity(Order order){
        System.out.println("Producing event");
        this.kafkaTemplate.send(TOPIC, order);
    }

}
