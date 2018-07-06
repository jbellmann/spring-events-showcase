package de.jbellmann.spring.events.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;
import org.springframework.scheduling.annotation.Async;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
@Async
public @interface AsyncEventListener {

    @AliasFor(annotation = EventListener.class, attribute = "value")
    Class<?>[] value() default {};

    @AliasFor(annotation = EventListener.class, attribute = "classes")
    Class<?>[] classes() default {};

    @AliasFor(annotation = EventListener.class, attribute = "condition")
    String condition() default "";
}
