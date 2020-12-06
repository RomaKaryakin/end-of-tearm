package kz.karyakin.orderservice.model.dto;

import kz.karyakin.orderservice.model.entity.Employee;
import kz.karyakin.orderservice.model.entity.Meal;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Employee receiver;

    private List<Meal> meals;

}
