package kz.karyakin.reservationservice.util;

import kz.karyakin.reservationservice.exception.DefaultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionUtils {

    public void throwDefaultException(MessageCode messageCode){
        throw new DefaultException(messageCode.getDefaultMessage(), messageCode.getErrorCode());
    }


}
