package kz.karyakin.menuservice.model.dto;

import kz.karyakin.menuservice.model.entity.Meal;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MealsListDTO {

    private List<Meal> meals;

}
