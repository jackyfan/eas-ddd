package xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zhangyi.ddd.core.stereotype.DomainService;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.course.CourseId;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.south.port.repository.TrainingRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@DomainService
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public Training trainingOf(TrainingId trainingId) {
        Optional<Training> optionalTraining = trainingRepository.trainingOf(trainingId);
        return optionalTraining.orElseThrow(() -> trainingNotFoundError(trainingId));
    }

    public void addTraining(String title, String description, LocalDateTime beginTime, LocalDateTime endTime,
                            String place, CourseId courseId) {
        Training training = new Training(title, description, beginTime, endTime,
                place, courseId);
        trainingRepository.add(training);
    }

    private TrainingException trainingNotFoundError(TrainingId trainingId) {
        return new TrainingException(String.format("Training by id {%s} is not found.", trainingId));
    }

    public void setTrainingRepository(TrainingRepository trainingRepo) {
        trainingRepository = trainingRepo;
    }
}