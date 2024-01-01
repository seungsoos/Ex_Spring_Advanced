package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    void begin_end() {
        HelloTraceV2 traceV1 = new HelloTraceV2();
        TraceStatus hello = traceV1.begin("hello");
        traceV1.end(hello);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 traceV1 = new HelloTraceV2();
        TraceStatus hello = traceV1.begin("hello");
        traceV1.exception(hello, new IllegalStateException());
    }

}