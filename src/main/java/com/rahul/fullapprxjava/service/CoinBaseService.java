package com.rahul.fullapprxjava.service;

import com.rahul.fullapprxjava.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinBaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);
}
