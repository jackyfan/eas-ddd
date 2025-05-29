package xyz.zhangyi.ddd.eas.valueadded.trainingcontext.north.message;

import lombok.Getter;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.course.CourseId;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.training.Training;

import java.io.Serializable;
import java.time.LocalDateTime;
@Getter
public class AddTrainingRequest implements Serializable {
    private String title;
    private String description;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String place;
    private String courseId;

    public AddTrainingRequest(String title, String description, LocalDateTime beginTime, LocalDateTime endTime,
                              String place, String courseId) {
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
        this.courseId = courseId;
    }
    public Training toTraining(){
        return new Training(this.title,this.description,this.beginTime,this.endTime,this.place,
                CourseId.from(this.courseId));
    }

}
