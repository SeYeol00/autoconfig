package hello.selector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ImportSelectorTest {


    @Test
    void staticConfig(){
        // 정적인 방식
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        Assertions.assertThat(bean).isNotNull();
    }

    @Test
    void selectorConfig(){
        // 동적인 방식
        AnnotationConfigApplicationContext appContext =
                new AnnotationConfigApplicationContext(SelectorConfig.class);
        HelloBean bean = appContext.getBean(HelloBean.class);
        Assertions.assertThat(bean).isNotNull();
    }


    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig{
    }

    @Configuration // import selector를 구현한 클래스
    // 임포터에 selector도 넣을 수 있다.
    @Import(HelloImportSelector.class)
    public static class SelectorConfig{
    }
}
