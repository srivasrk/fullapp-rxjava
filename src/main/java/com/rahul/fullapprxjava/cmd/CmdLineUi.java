package com.rahul.fullapprxjava.cmd;

import com.rahul.fullapprxjava.Observer.ConsolePrintObserver;
import com.rahul.fullapprxjava.service.CoinBaseService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class CmdLineUi implements CommandLineRunner {

    @Autowired
    private CoinBaseService coinBaseService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\nRxJava Programming with java 8\n");

        Observable.interval(3000, TimeUnit.MILLISECONDS, Schedulers.io())
                .map( tick -> coinBaseService.getCryptoPrice("BTC-USD"))
                .subscribe(new ConsolePrintObserver());


        Observable.interval(3000, TimeUnit.MILLISECONDS, Schedulers.io())
                .map( tick -> coinBaseService.getCryptoPrice("ETH-USD"))
                .subscribe(new ConsolePrintObserver());
    }
}
