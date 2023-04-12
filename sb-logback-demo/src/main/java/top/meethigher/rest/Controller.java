package top.meethigher.rest;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = {
            "/logLevel/{level}",
            "/logLevel"
    })
    public String changeLogLevel(@PathVariable(value = "level", required = false) String level) {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        if (level == null) {
            return rootLogger.getLevel().levelStr;
        } else {
            Level value = Level.valueOf(level);
            rootLogger.setLevel(value);
            return level;
        }
    }
}
