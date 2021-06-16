package com.julianduru.util.entity;

import java.time.ZonedDateTime;


public interface TimeStampAware {


    ZonedDateTime getTimeAdded();


    ZonedDateTime getTimeUpdated();


}
