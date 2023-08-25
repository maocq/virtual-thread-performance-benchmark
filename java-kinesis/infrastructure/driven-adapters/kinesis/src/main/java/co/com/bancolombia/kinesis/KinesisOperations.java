package co.com.bancolombia.kinesis;

import co.com.bancolombia.model.logs.Log;
import co.com.bancolombia.model.logs.gateways.LogGateway;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class KinesisOperations implements LogGateway {

    private final KinesisAsyncClient kinesisClient;
    private final ObjectMapper mapper;

    @Override
    public Mono<String> emit(Log log) {
        var recordRequest = PutRecordRequest.builder()
                .partitionKey(UUID.randomUUID().toString())
                .streamName("poc_galatea")
                .data(SdkBytes.fromByteArray(getJson(log).getBytes()))
                .build();

        return Mono.fromFuture(kinesisClient.putRecord(recordRequest))
                .map(PutRecordResponse::shardId);
    }

    @SneakyThrows
    private <T> String getJson(T value) {
        return mapper.writeValueAsString(value);
    }
}
