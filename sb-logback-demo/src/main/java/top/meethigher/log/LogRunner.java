package top.meethigher.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class LogRunner implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(LogRunner.class);


    @Override
    public void run(String... args) throws Exception {
        new Timer("debug").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.debug("我是debug");
            }
        }, 0L, 1000L);
        new Timer("info").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("我是info");
            }
        }, 0L, 1000L);
        new Timer("warn").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.warn("我是warn");
            }
        }, 0L, 1000L);
        new Timer("error").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.error("我是error");
            }
        }, 0L, 1000L);
    }
}
