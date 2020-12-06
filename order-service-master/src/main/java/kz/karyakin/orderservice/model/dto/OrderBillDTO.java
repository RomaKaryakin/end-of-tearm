package kz.karyakin.orderservice.model.dto;

import kz.karyakin.orderservice.model.entity.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderBillDTO {

    private Order order;

    private double bill;

}
