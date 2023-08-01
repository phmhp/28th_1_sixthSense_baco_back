package solux.baco.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import solux.baco.service.MapHtmlService;
import solux.baco.service.ReviewModel.ReviewDetailDTO;
import solux.baco.service.ReviewModel.returnReviewDataDTO;
import solux.baco.service.RouteModel.JsonDataEntity;

@Slf4j
@Controller
public class MapTestController {

    private final MapHtmlService mapHtmlService;

    @Autowired
    public MapTestController(MapHtmlService mapHtmlService) {
        this.mapHtmlService = mapHtmlService;

    }

    @GetMapping("/mapTest")
    public String showMapPage(@RequestParam String review_id, Model model) {
        log.info("checklog: MapTestController-showMapPage-review_id:{}", review_id);
        Long review_idLong = Long.parseLong(review_id);
        String jsonData = mapHtmlService.getJsonData(review_idLong);
        log.info("checklog: MapTestController-showMapPage-jsonData:{}", jsonData);
        if (jsonData != null) {

            //jsonData를 파싱해서 이중배열형태로 다시 만들기 위해 service 호출
            Double[][] jsonDataArray = mapHtmlService.makeArray(jsonData);




            //if (routeParameter != null)
            //JsonData를 html에 렌더링하기 위해 Thymeleaf 템플릿으로 전달. (=Thymeleaf를 통해 html로 전달)
            model.addAttribute("jsonData", jsonDataArray); //jsonDTO형태로 맞춰서 저장했다가 getter메서드로 가져와서 model로 전달하기.


            // HTML 파일 이름 (확장자 제외)을 리턴
        }
        return "mapTest"; }
}
