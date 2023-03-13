package hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        // given
        Member member = new Member("idA", "memberA");
        memberRepository.initTable();
        memberRepository.save(member);
        // when
        Member findMember = memberRepository.find("idA");
        // then
        assertThat(member.getMemberId()).isEqualTo(findMember.getMemberId());
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void save() {
    }

    @Test
    void find() {
    }

    @Test
    void findAll() {
    }
}