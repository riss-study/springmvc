package dev.riss.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j  // 아래의 log 선언 및 초기화를 알아서 해주는 롬복 어노테이션
public class LogTestController {

//    private final static Logger log= LoggerFactory.getLogger(LogTestController.class);
//    private final Logger log= LoggerFactory.getLogger(getClass());            // 둘 중 아무렇게나 선언해도 됨

    @GetMapping("/log-test")
    public String logTest () {
        String name = "Spring";

        System.out.println("name = " + name);   // 이건 다 콘솔에만 남기기 때문에 좋지 않음. 로그는 콘솔에도, 파일에도 남길 수 있음

        log.trace("trace log{}", name);     // , 로 하면 메서드를 호출하고 파라미터만 넘기기 때문에 아무 연산이 일어나지 않음
        // log level 이 debug 이상이라면 => trace 기 때문에 이 메서드 호출하지 않고 로직이 중지가 됨
        log.trace("trace my log=" + name);  // 이렇게 쓰면 자바 언어 특성 상 연산이 일어남
        // (문자 + 때문에 name인 Spring을 앞의 문자열과 더해서 "trace my log=Spring" 이라는 문자를 만들어서 저장해놓음)
        // => trace 를 사용하지 않는 레벨 세팅을 하더라도 해당 연산은 이루어져서 메모리에 저장돼있음 => 실무에서 조오온나 혼나고 욕먹음
        log.debug("debug log{}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
