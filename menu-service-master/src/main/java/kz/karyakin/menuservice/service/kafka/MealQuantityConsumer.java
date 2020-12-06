package kz.karyakin.menuservice.service.kafka;

import kz.karyakin.menuservice.model.entity.Meal;
import kz.karyakin.menuservice.model.entity.Order;
import kz.karyakin.menuservice.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MealQuantityConsumer {

    private final MealRepository mealRepository;

    @KafkaListener(topics = "restaurant-events", groupId = "group_id")
    public void consume(Order order) throws IOException {
        System.out.println("Consuming event");

        for(Meal meal: order.getMeals()){
            Meal mealFromDb = mealRepository.findById(meal.getId()).get();

            mealFromDb.setQuantity(mealFromDb.getQuantity() - 1);

            mealRepository.save(mealFromDb);

        }

    }

}
