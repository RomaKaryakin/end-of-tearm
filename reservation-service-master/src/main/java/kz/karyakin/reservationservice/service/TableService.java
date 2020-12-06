package kz.karyakin.reservationservice.service;

import kz.karyakin.reservationservice.repository.TableRepository;
import kz.karyakin.reservationservice.model.entity.Table;
import kz.karyakin.reservationservice.util.ExceptionUtils;
import kz.karyakin.reservationservice.util.MessageCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;
    private final ExceptionUtils exceptionUtils;

    public Table createTable(Table table){
        return tableRepository.save(table);
    }

    public Table getTable(Long id){

        if(!tableRepository.existsById(id)){
            exceptionUtils.throwDefaultException(MessageCode.TABLE_DOES_NOT_EXIST);
        }

        return tableRepository.findById(id).get();

    }

    public List<Table> getTables(){
        return tableRepository.findAll();
    }

}
