package com.julianduru.util.stream;

import com.julianduru.util.entity.TimeStampAware;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * created by julian
 */
@Setter
@Getter
public class PullStreamData<T> extends PageImpl<T> {


    private Long minTimeStamp;


    private Long maxTimeStamp;



    public PullStreamData(Page<T> page) {
        super(page.getContent(), page.getPageable(), page.getTotalElements());
        setTimestamps();
    }


    public PullStreamData(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
        setTimestamps();
    }


    public PullStreamData(List<T> content) {
        super(content);
        setTimestamps();
    }


    public void setTimestamps() {
        if (this.getContent() == null) {
            return;
        }

        getContent()
            .forEach(item -> {
                if (!(item instanceof TimeStampAware)) {
                    return;
                }

                var timeStampedItem = (TimeStampAware) item;
                if (timeStampedItem.getTimeAdded() == null) {
                    return;
                }

                var timeAdded = timeStampedItem.getTimeAdded().toInstant().toEpochMilli();

                if (minTimeStamp == null) {
                    minTimeStamp = timeAdded;
                }

                if (maxTimeStamp == null) {
                    maxTimeStamp = timeAdded;
                }

                if (minTimeStamp > timeAdded) {
                    minTimeStamp = timeAdded;
                }

                if (maxTimeStamp < timeAdded) {
                    maxTimeStamp = timeAdded;
                }
            });
    }


}


