package dev.danvega.newsletter.convertkit.forms;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SubscriberRequest(
        String email,
        String formId,
        @JsonProperty("api_key")
        String apiKey
) {


}
