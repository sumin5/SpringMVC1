package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {


    private Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping({"/hello-basic","/hello-go"})
    public String helloBasic(){
        log.info("helloBasic");
        return  "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}",data);
        return "ok";
    }



    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}", userId,orderId);
        return "ok";
    }


    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }


    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mapping-header");
        return "ok";
    }

    @PostMapping(value = "/mapping-counsume",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce",produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce(){
        log.info("mappingProduce");
        return "ok";
    }
}
