package aakahori.sample.spring.webflux.controller;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    private static final String HELLO_WORLD = "Hello, world.";

    @GetMapping("/webmvc")
    public String webmvc(long wait) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(wait);
        return HELLO_WORLD;
    }

    @GetMapping("/webflux")
    public Mono<String> webflux(long wait) {
        return Mono.just(HELLO_WORLD).delayElement(Duration.ofMillis(wait));
    }
}
