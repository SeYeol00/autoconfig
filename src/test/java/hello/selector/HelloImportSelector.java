package hello.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 배열에 있는 경로를 이용하여 동적으로 configuration을 가져올 수 있다.
        // 코드를 실행하여 이 함수가 반환하는 문자에 맞는 대상을 설정 정보로 사용한다.
        // 그러면 configuration을 이용한 스프링 컨테이너를 사용한다.
        return new String[]{"hello.selector.HelloConfig"};
    }
}
