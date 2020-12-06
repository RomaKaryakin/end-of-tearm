package kz.karyakin.reservationservice.controller;

import kz.karyakin.reservationservice.repository.ReservationRepository;
import kz.karyakin.reservationservice.model.entity.Reservation;
import kz.karyakin.reservationservice.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationRepository reservationRepository;

    private static final String RESERVATION = "/reservation";
    private static final String GET_RESERVATIONS = RESERVATION + "/list";


    @PostMapping(RESERVATION)
    public ResponseEntity<Reservation> reserveTable(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.reserveTable(reservation), HttpStatus.CREATED);
    }

    @GetMapping(GET_RESERVATIONS)
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }

}
