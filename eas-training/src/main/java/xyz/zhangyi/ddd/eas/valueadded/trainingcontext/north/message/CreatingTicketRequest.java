package xyz.zhangyi.ddd.eas.valueadded.trainingcontext.north.message;

import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.candidate.Candidate;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.ticket.Nominator;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.ticket.TicketId;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.ticket.TicketStatus;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.ticket.TrainingRole;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.domain.training.TrainingId;

import java.io.Serializable;

// Request Message: DTO
public class CreatingTicketRequest implements Serializable {
    private String ticketId;
    private String trainingId;


    public CreatingTicketRequest() {
    }

    public CreatingTicketRequest(String ticketId,
                                 String trainingId) {
        this.ticketId = ticketId;
        this.trainingId = trainingId;
    }

    public TicketId getTicketId() {
        return TicketId.from(this.ticketId);
    }

    public TrainingId getTrainingId() {
        return TrainingId.from(this.trainingId);
    }

}