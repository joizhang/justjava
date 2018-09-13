package com.joizhang.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ReactorDemoTest {

    @Test
    public void fluxJustTest() {
        Flux.just("1", "A", 3).subscribe(System.out::println);
    }

    @Test
    public void fluxIntervalTest() throws InterruptedException {
        Flux.interval(Duration.of(500, ChronoUnit.MILLIS))
                .subscribe(System.out::println);
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Test
    public void fluxEmptyTest() {
        Flux.empty().subscribe(System.out::println);
    }

    @Test
    public void fluxErrorTest() {
        Flux.error(new Exception("Something is wrong!")).subscribe(System.out::println);
    }

    @Test
    public void fluxGenerateTest() {
        Flux.generate(i -> {
            i.next("AAAAA");
            // generate中next只能调用1次
            i.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, item) -> {
            Integer value = random.nextInt(100);
            list.add(value);
            item.next(value);
            if (list.size() >= 10) {
                item.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void fluxCreateTest() {
        Flux.create(i -> {
            i.next("A");
            i.next("B");
            i.complete();
        }).subscribe(System.out::println);


    }

}