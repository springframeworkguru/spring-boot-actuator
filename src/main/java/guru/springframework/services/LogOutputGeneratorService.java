package guru.springframework.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/28/16.
 */
@Component
public class LogOutputGeneratorService {

    private static Logger log = LoggerFactory.getLogger(LogOutputGeneratorService.class);

    @Scheduled(fixedDelay = 500)
    public void createLogEntries(){
        log.trace("This is a TRACE message");
        log.debug("This is a DEBUG message");
        log.info("This is a INFO message");
        log.warn("This is a WARN message");
        log.error("This is an ERROR message");
    }
}
