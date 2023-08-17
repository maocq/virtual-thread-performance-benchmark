package co.com.bancolombia.kinesis.config;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KinesisConfig {

    @Bean
    public KinesisProducer kinesisProducer() {
        KinesisProducerConfiguration config = new KinesisProducerConfiguration()
                //.setRecordMaxBufferedTime(3000)
                //.setMaxConnections(5)
                //.setRequestTimeout(60000)
                .setRegion("us-east-1");

        return new KinesisProducer(config);
    }
}
