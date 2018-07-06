package de.jbellmann.spring.events.example;

import static java.lang.Thread.currentThread;
import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    private static final Logger log = LoggerFactory.getLogger(CustomEventListener.class);

    @EventListener
    public void onCustomEvent(CustomEvent e) {
        final String threadName = currentThread().getName();
        assertThat(e.getName()).isEqualTo(threadName);
        log.info("HANDLE SYNC EVENT ON THREAD : {}", threadName);
    }
}
