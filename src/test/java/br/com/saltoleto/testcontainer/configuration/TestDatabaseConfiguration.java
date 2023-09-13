package br.com.saltoleto.testcontainer.configuration;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class TestDatabaseConfiguration {

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
        initializer.setDatabasePopulator(populator);

        return initializer;
    }

     @Container
    public static GenericContainer<?> sqsContainer = new GenericContainer<>("amazon/localstack")
            .withExposedPorts(4566)
            .withEnv("DEFAULT_REGION", "us-east-1")
            .withEnv("AWS_ACCESS_KEY_ID", "test")
            .withEnv("AWS_SECRET_ACCESS_KEY", "test");

    private SqsAsyncClient sqsClient;

    @BeforeEach
    void setup() {
        String sqsEndpoint = "http://" + sqsContainer.getHost() + ":" + sqsContainer.getMappedPort(4566);
        sqsClient = SqsAsyncClient.builder()
                .endpointOverride(URI.create(sqsEndpoint))
                .build();
    }

    @AfterEach
    void cleanup() {
        sqsClient.close();
    }

    @Test
    void testSqsIntegration() {
        // Your SQS integration test logic here
    }
}
In this example, we're using the GenericContainer from Testcontainers to run a local instance of AWS LocalStack, which provides a local version of SQS. We configure the client to connect to this local SQ
}
