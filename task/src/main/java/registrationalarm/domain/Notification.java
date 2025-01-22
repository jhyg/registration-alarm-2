package registrationalarm.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import registrationalarm.TaskApplication;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    private String notificationId;

    private String userId;

    private String taskId;

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = TaskApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
//>>> DDD / Aggregate Root
