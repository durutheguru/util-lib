package com.julianduru.util.stream;

import lombok.*;
import org.springframework.data.domain.Pageable;


@Data
@Builder
public class PullStreamDataRequest {


    private Pageable pageable;


    private Long beforeTimeStamp;


    private Long afterTimeStamp;


    public boolean hasBeforeTimeStamp() {
        return beforeTimeStamp != null && beforeTimeStamp > 0;
    }


    public boolean hasAfterTimeStamp() {
        return afterTimeStamp != null && afterTimeStamp > 0;
    }


    public boolean hasAllTimeStamps() {
        return hasBeforeTimeStamp() && hasAfterTimeStamp();
    }


}

