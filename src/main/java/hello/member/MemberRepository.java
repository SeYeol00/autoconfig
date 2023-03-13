package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void initTable(){
        template.execute("create table member(member_id varchar primary key, name varchar)");
    }

    public void save(Member member){
        template.update("insert into member(member_id, name) values(?,?)",
                member.getMemberId(),
                member.getName());
    }

    public Member find(String memberId){
        return template.queryForObject("select member_id, name from member where member_id=?",
                // 아래 클래스로 위 쿼리 결과를 멤버 클래스로 객체화 해서 던져줌
                BeanPropertyRowMapper.newInstance(Member.class),
                memberId);
    }

    public List<Member> findAll(){
        return template.query("select member_id, name from memeber",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}
