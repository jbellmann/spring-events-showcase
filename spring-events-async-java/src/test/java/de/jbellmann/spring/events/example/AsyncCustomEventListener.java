package de.jbellmann.spring.events.example;

import static java.lang.Thread.currentThread;
import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.jbellmann.spring.events.meta.AsyncEventListener;

@Component
public class AsyncCustomEventListener {

    private static final Logger log = LoggerFactory.getLogger(AsyncCustomEventListener.class);

    @AsyncEventListener
    public void onCustomEvent(CustomEvent e) {
        final String threadName = currentThread().getName();
        assertThat(e.getName()).isNotEqualTo(threadName);
        log.info("HANDLE ASYNC EVENT ON THREAD : {}", threadName);
    }
}
