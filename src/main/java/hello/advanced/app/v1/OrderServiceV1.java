package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    public final OrderRepositoryV1 orderRepository;
    public final HelloTraceV1 trace;

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
