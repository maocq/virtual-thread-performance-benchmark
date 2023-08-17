package co.com.bancolombia.model.logs.gateways;

import co.com.bancolombia.model.logs.Log;
import reactor.core.publisher.Mono;

public interface LogGateway {

    Mono<String> emit(Log log);
}
