package co.com.bancolombia.kinesis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;

@Configuration
public class KinesisConfig {

    @Bean
    public KinesisAsyncClient kinesisClient() {
        return KinesisAsyncClient.builder()
                .region(Region.of("us-east-1"))
                .build();
    }
}
