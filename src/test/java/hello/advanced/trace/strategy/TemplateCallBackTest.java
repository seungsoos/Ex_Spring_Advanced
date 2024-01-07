package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.CallBack;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callBackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });

        timeLogTemplate.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callBackV2() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("비지니스 로직 1 실행"));
        timeLogTemplate.execute(() -> log.info("비지니스 로직 2 실행"));
    }

}
