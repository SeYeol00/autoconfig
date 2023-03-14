package hello.config;

import memory.Memory;
import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


// Memory 외부 라이브러리를 쓰기 위해서는 빈 등록을 해주어야 한다.
@Configuration
// 이 어노테이션은 if문과 같이 조건이 참일 때만 이 클래스를 실행한다.
//@Conditional(MemoryCondition.class)
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryConfig {

    @Bean
    public MemoryController memoryController(){
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder(){
        return new MemoryFinder();
    }
}
