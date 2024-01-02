package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public FieldLogTrace fieldLogTrace() {
        return new FieldLogTrace();
    }
}
