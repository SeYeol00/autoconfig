package memory;

// 자바 메모리 사용을 관찰할 수 있는 모듈을 만들 것임
// 완전히 다른 패키지로 만들어야 뗴어내기 편함
public class Memory {
    private long used;
    private long max;


    public Memory(long used, long max) {
        this.used = used;
        this.max = max;
    }

    public long getUsed() {
        return used;
    }

    public long getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", max=" + max +
                '}';
    }
}
