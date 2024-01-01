package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    public final OrderRepositoryV2 orderRepository;
    public final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(traceId, itemId);
            trace.end(status);
        } catch (Exception e) {
            this.trace.exception(status, e);
            throw e;
        }

    }
}
