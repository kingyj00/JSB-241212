package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
}

// 지금처럼 강제 종료됩니다./
//1. 리팩터링과정에서 인텔리제이가 mappedBy의 question을 경로로 인식해 src/main이하의 경로로 바꾸었음
//llection 'com.mysite.sbb.question.Question.answerList' is 'mappedBy' a property named 'com/mysite/sbb/question' which does not exist in the target entity 'com.mysite.sbb.answer.Answer'
//2. 위와같이 인텔리제이가 QuestionController의 /question/list의 경로를 수정함
//더궁금하신것있으실까요?

// 방금처럼 뭔가 진행이 안될 때, 밑에 뭘 보고 오류를 예측하시는건가요?
// 혹시 디버깅을 좀 해보셨을까요? 디버깅이란 행위/행동자체

// 옆에 벌레모양 눌러서 돌리는거말씀하시는건가여?
// 그것도 디버깅이 맞고, 에러가 났을시에 에러 메세지를 차근차근 훑어서 원인을 찾아보는것도 디버깅인데
// 방금 제가 적은 방법으로 첫번째 문제를 찾았습니다.
// 그리고 두번째는... 시간 경험 노력 등등등
// 음 디버깅을 하긴해본느데 오류가나면, 비기너라 봐도 뭐가 뭔지 잘몰라서
// 뭔가 error 혹은 오류라고 생각되는 문단을 찾기가 힘듭니다.
// 일단 java에서 오류시 출력되는 문구는 오류의 stackTrace를 호출하는데
// 이친구는 프로그램의 시작점부터 오류가 난 지점까지 호출된 함수들을 쫙 보여줍니다
// 1번케이스(mappedBy가 잘못된) 같은 경우를 보면
// org.springframework~~에서부터 차례대로 org.hibernate.boot~ 이렇게 각 패키지의 함수들을 차례대로 호출하다
// 마지막에 caused By라고 실제 오류를 발생 시킨 지점의 오류를 보여줍니다.
// 그리고 해당 오류가 왜 발생했는지를 차근차근 뜯어봅니다
// 방금과같은 오류는 꽤나 친절하게 알려주고 있으니
// 앞으로도 과제 진행중에 오류메세지가 뜨는 에러를 발생하게되면 한번 쓱 훑어보시는 것도 좋을겁니다.
// 네 감사합니다.공유종료하겠습니다.네
