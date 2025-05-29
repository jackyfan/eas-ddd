package xyz.zhangyi.ddd.eas.valueadded.trainingcontext.north.remote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.zhangyi.ddd.core.gateway.north.Resources;
import xyz.zhangyi.ddd.core.stereotype.Remote;
import xyz.zhangyi.ddd.core.stereotype.RemoteType;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.north.local.appservice.NominationAppService;
import xyz.zhangyi.ddd.eas.valueadded.trainingcontext.north.message.NominatingCandidateRequest;

import java.util.logging.Logger;

@RestController
@RequestMapping("/tickets")
@Remote(RemoteType.Controller)
public class TicketController {
    private Logger logger = Logger.getLogger(TicketController.class.getName());

    @Autowired
    private NominationAppService nominationAppService;

    @PostMapping
    public ResponseEntity<?> nominate(@RequestBody NominatingCandidateRequest nominatingCandidateRequest) {
        return Resources.with("nominate ticket")
                .onSuccess(HttpStatus.ACCEPTED)
                .onError(HttpStatus.BAD_REQUEST)
                .onFailed(HttpStatus.INTERNAL_SERVER_ERROR)
                .execute(() -> nominationAppService.nominate(nominatingCandidateRequest));
    }
}