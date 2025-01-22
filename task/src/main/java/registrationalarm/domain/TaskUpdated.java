package registrationalarm.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import registrationalarm.domain.*;
import registrationalarm.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TaskUpdated extends AbstractEvent {

    private String taskId;
    private String userId;
    private String title;
    private String description;
    private Date dueDate;

    public TaskUpdated(Task aggregate) {
        super(aggregate);
    }

    public TaskUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
