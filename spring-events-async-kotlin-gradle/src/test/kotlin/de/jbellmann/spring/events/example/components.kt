package de.jbellmann.spring.events.example

import de.jbellmann.spring.events.meta.AsyncEventListener
import org.assertj.core.api.Assertions
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

data class CustomEvent(val name: String = Thread.currentThread().name)

@Component
class EventProducer(private val publisher: ApplicationEventPublisher) {

    private val log = LoggerFactory.getLogger(EventProducer::class.java)

    @Scheduled(initialDelay = 2_000, fixedDelay = 2_000)
    fun sendEvent() {
        val e = CustomEvent()
        publisher.publishEvent(e)
        log.info("EVENT PUBLISHED ON THREAD : ${e.name}")
    }
}

@Component
class AsyncCustomEventListener {

    private val log = LoggerFactory.getLogger(AsyncCustomEventListener::class.java)

    @AsyncEventListener
    fun onCustomEvent(e: CustomEvent ) {
        val threadName = Thread.currentThread().name
        Assertions.assertThat(e.name).isNotEqualTo(threadName)
        log.info("HANDLE ASYNC EVENT ON THREAD $threadName")
    }
}

@Component
class CustomEventListener {

    private val log = LoggerFactory.getLogger(CustomEventListener::class.java)

    @EventListener
    fun onCustomEvent(e: CustomEvent){
        val threadName = Thread.currentThread().name
        Assertions.assertThat(e.name).isEqualTo(threadName)
        log.info("HANDLE SYNC EVENT ON THREAD $threadName")
    }
}
