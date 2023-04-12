package dev.riss.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1 () {
        ModelAndView mv = new ModelAndView("response/hello")
                .addObject("data", "hello riss!!");

        return mv;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2 (Model model) {
        model.addAttribute("data", "hello riss!!");

        return "response/hello";
    }

    @RequestMapping("/response/hello")      // 이 url 경로의 이름이랑 논리적인 뷰 이름이랑 같을 때 이렇게도 사용 가능 (절대 권장하지 않음, 명시성이 부족, 이렇게 url 이 딱 맞는 경우도 거의 드뭄)
    public void responseViewV3 (Model model) {
        model.addAttribute("data", "hello riss!!");
    }

}
