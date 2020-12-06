package kz.karyakin.reservationservice.repository;

import kz.karyakin.reservationservice.model.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

}
