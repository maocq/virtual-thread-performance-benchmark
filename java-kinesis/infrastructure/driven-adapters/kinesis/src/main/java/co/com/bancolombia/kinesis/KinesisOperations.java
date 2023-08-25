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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Service
public class KinesisOperations implements LogGateway {
    //private static final ForkJoinPool pool = ForkJoinPool.commonPool();
    private static final ExecutorService pool = Executors.newFixedThreadPool(30);

    private final KinesisProducer kinesisProducer;
    private final ObjectMapper mapper;

    @Override
    public Mono<String> emit(Log log) {

        var count = kinesisProducer.getOutstandingRecordsCount();
        if (count > 2000)
            System.out.println(count);

        ListenableFuture<UserRecordResult> future = kinesisProducer
                .addUserRecord("poc_galatea", UUID.randomUUID().toString(), ByteBuffer.wrap(getJson(log).getBytes()));

        FutureCallback<UserRecordResult> callback = getUserRecordResultFutureCallback();
        Futures.addCallback(future, callback, pool);

        return Mono.just("Ok");
    }

    private static FutureCallback<UserRecordResult> getUserRecordResultFutureCallback() {
        return new FutureCallback<>() {
            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(UserRecordResult result) {
                System.out.println(result.getShardId());
            }
        };
    }

    @SneakyThrows
    private <T> String getJson(T value) {
        return mapper.writeValueAsString(value);
    }
}