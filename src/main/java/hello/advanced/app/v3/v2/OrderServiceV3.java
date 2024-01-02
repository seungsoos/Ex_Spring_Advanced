package hello.advanced.app.v3.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    public final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }

    }
}
