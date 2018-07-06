package de.jbellmann.spring.events.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    private static final Logger log = LoggerFactory.getLogger(EventProducer.class);

    private final ApplicationEventPublisher publisher;

    public EventProducer(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Scheduled(initialDelay = 2_000, fixedDelay = 2_000)
    public void sendEvent() {
        final String threadName = Thread.currentThread().getName();
        publisher.publishEvent(new CustomEvent(threadName));
        log.info("EVENT PUBLISHED ON THREAD : {}", threadName);
    }

}
