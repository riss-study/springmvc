package dev.riss.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic () {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1 () {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2 () {
        log.info("mappingGetV2");
        return "ok";
    }


    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVaraible("userId") String userId -> @PathVariable userId
     * @param data
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath (@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    // 실제 파라미터로 mode=debug 가 있는 경우만 호출 가능 아니면 bad request, params 안에 배열로 넣어서 선택 적으로 가능( params={"mode=debug", "data=good"})
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam () {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    //헤더에 mode 값에 debug 라는 value 를 넣어줘야 이 메서드 호출 가능, 아니면 404 뜸
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader () {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes () {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces () {
        log.info("mappingProduces");
        return "ok";
    }
}
