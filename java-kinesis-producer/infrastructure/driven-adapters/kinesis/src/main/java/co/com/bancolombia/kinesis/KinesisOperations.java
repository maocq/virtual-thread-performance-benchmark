package co.com.bancolombia.kinesis;

import co.com.bancolombia.model.logs.Log;
import co.com.bancolombia.model.logs.gateways.LogGateway;
import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.UserRecordResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;

@RequiredArgsConstructor
@Service
public class KinesisOperations implements LogGateway {
    private static final ForkJoinPool pool = ForkJoinPool.commonPool();

    private final KinesisProducer kinesisProducer;
    private final ObjectMapper mapper;

    @Override
    public Mono<String> emit(Log log) {
        return Mono.<UserRecordResult>create(monoSink -> {
            ListenableFuture<UserRecordResult> future = kinesisProducer
                    .addUserRecord("poc_galatea", UUID.randomUUID().toString(), ByteBuffer.wrap(getJson(log).getBytes()));

            FutureCallback<UserRecordResult> callback = getUserRecordResultFutureCallback(monoSink);
            Futures.addCallback(future, callback, pool);
        }).map(UserRecordResult::getShardId);
    }

    private static FutureCallback<UserRecordResult> getUserRecordResultFutureCallback(MonoSink<UserRecordResult> monoSink) {
        return new FutureCallback<>() {
            @Override
            public void onFailure(Throwable t) {
                monoSink.error(t);
            }

            @Override
            public void onSuccess(UserRecordResult result) {
                monoSink.success(result);
            }
        };
    }

    @SneakyThrows
    private <T> String getJson(T value) {
        return mapper.writeValueAsString(value);
    }
}