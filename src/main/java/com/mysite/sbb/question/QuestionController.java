package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
//폴더들의 위치가 잘못되어있었네요, user도 com.mysite.sbb 아래의 폴더로 옮겨주시면 되겠씁니다.
//더궁금한게있으실까요?

//저도 그런줄 알고 혼자 폴더들 com.sbb 안으로 넣어놓고 실행했을때는, 그냥 강제 종료되던데
// 이번엔 뭐가 달라서 된거죠?
//한번 제가 이전상황으로 바꿔볼테니 해보시겠어요?
//네