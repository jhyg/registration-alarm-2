package registrationalarm.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import registrationalarm.domain.*;
import registrationalarm.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TaskDeleted extends AbstractEvent {

    private String taskId;

    public TaskDeleted(Task aggregate) {
        super(aggregate);
    }

    public TaskDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
