package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryFinder {

    public Memory get(){
        // 현재 런타임에서 사용하는 메모리 사용량 가져오기
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        long used = total - free;
        return new Memory(used,max);
    }

    @PostConstruct
    public void init(){
        log.info("init memoryFinder");
    }
}
