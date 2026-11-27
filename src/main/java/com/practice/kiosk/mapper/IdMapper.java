package com.practice.kiosk.mapper;

import com.practice.kiosk.dto.TempDto;
import org.springframework.stereotype.Component;

@Component
public class IdMapper {

    public TempDto toDto(Integer id){
        return new TempDto(id);
    }

    public Integer toInteger(TempDto tempDto){
        return tempDto.id();
    }
}
