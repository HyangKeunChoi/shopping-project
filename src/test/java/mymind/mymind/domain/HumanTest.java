package mymind.mymind.domain;

import mymind.mymind.repository.HumanPureJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HumanTest {
    @Autowired
    HumanPureJpaRepository humanPureJpaRepository;

    @Test
    @Transactional
    @DisplayName("Jpa 실행 테스트")
    public void testHuman() {

        // given
        Human human = new Human();
        human.setUserName("최향근");
        Long saveId = humanPureJpaRepository.save(human);

        // when
        Human findHuman = humanPureJpaRepository.findById(saveId);

        // then
        assertThat(findHuman.getId()).isEqualTo(human.getId());
    }
}