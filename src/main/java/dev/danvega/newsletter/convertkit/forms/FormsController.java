package dev.danvega.newsletter.convertkit.forms;

import dev.danvega.newsletter.convertkit.ConvertKitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/forms")
public class FormsController {

    private static final Logger log = LoggerFactory.getLogger(FormsController.class);
    private final ConvertKitProperties ckProps;
    private final RestClient restClient;

    public FormsController(ConvertKitProperties ckProps) {
        this.ckProps = ckProps;
        this.restClient = RestClient.create("https://api.convertkit.com/v3");
    }

    @GetMapping("/subscribe")
    void subscribe() {
        log.info("subscribe");
        log.info("ckProps: {}", ckProps);
    }

    @PostMapping("/subscribe")
    ResponseEntity<String> subscribe(@RequestBody SubscriberRequest subscriberRequest) {

        // do something else with the request...

        var body = new SubscriberRequest(subscriberRequest.email(),subscriberRequest.formId(),ckProps.apiKey());
        log.info("subscribe: {}", body);
        var response = restClient.post()
                .uri("/forms/5871346/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .toEntity(String.class);
        log.info("subscribe: {}", response);

        return response;
    }

}
