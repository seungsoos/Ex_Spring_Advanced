package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }
    /**
     * 익명 내부 클래스
     */
    @Test
    void strategyV2(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 1 실행");
            }
        });
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 2 실행");
            }
        });
    }

    /**
     * 람다 사용
     */
    void strategyV3(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비지니스 1 실행"));
        contextV2.execute(() -> log.info("비지니스 2 실행"));
    }

}
