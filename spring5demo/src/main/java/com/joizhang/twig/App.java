package com.joizhang.twig;

import com.joizhang.twig.core.SomeTask;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(App.class);

        SomeTask task = new SomeTask();
        task.execute();
    }
}
