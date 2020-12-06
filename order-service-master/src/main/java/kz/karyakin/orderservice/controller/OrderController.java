package kz.karyakin.orderservice.controller;

import kz.karyakin.orderservice.model.dto.OrderBillDTO;
import kz.karyakin.orderservice.model.dto.OrderDTO;
import kz.karyakin.orderservice.model.entity.Order;
import kz.karyakin.orderservice.repository.OrderRepository;
import kz.karyakin.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    private static final String ORDER = "/order";
    private static final String ORDER_PAY = ORDER + "/bill/{id}";
    private static final String ORDER_CANCEL = ORDER + "/cancel/{id}";
    private static final String GET_ORDERS = ORDER + "/list";

    @GetMapping(GET_ORDERS)
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(ORDER)
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.CREATED);
    }

    @PutMapping(ORDER_PAY)
    public ResponseEntity<OrderBillDTO> payBill(@PathVariable Long id){
        return new ResponseEntity<>(orderService.payBill(id), HttpStatus.OK);
    }

    @PutMapping(ORDER_CANCEL)
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id){
        return new ResponseEntity<>(orderService.cancelOrder(id), HttpStatus.OK);
    }

}
