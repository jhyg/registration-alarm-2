package registrationalarm.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import registrationalarm.TaskApplication;
import registrationalarm.domain.TaskCreated;
import registrationalarm.domain.TaskDeleted;
import registrationalarm.domain.TaskUpdated;

@Entity
@Table(name = "Task_table")
@Data
//<<< DDD / Aggregate Root
public class Task {

    @Id
    private String taskId;

    private String userId;

    private String title;

    private String description;

    private Date dueDate;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        registrationalarm.external.Notification notification = new registrationalarm.external.Notification();
        // mappings goes here
        TaskApplication.applicationContext
            .getBean(registrationalarm.external.NotificationService.class)
            .scheduleNotification(notification);

        TaskCreated taskCreated = new TaskCreated(this);
        taskCreated.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        registrationalarm.external.Notification notification = new registrationalarm.external.Notification();
        // mappings goes here
        TaskApplication.applicationContext
            .getBean(registrationalarm.external.NotificationService.class)
            .scheduleNotification(notification);

        TaskUpdated taskUpdated = new TaskUpdated(this);
        taskUpdated.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        registrationalarm.external.Notification notification = new registrationalarm.external.Notification();
        // mappings goes here
        TaskApplication.applicationContext
            .getBean(registrationalarm.external.NotificationService.class)
            .deleteNotification(notification);

        TaskDeleted taskDeleted = new TaskDeleted(this);
        taskDeleted.publishAfterCommit();
    }

    public static TaskRepository repository() {
        TaskRepository taskRepository = TaskApplication.applicationContext.getBean(
            TaskRepository.class
        );
        return taskRepository;
    }
}
//>>> DDD / Aggregate Root
