package br.com.lefranchi.playground.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class DurationBetweenInstants {

    public static void main(String[] args) throws InterruptedException {

        Instant one = Instant.now();

        TimeUnit.SECONDS.sleep(10);

        Instant two = Instant.now();

        Duration res = Duration.between(one, two);

        System.out.println(res.toMillis());

    }

}
