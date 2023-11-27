package dev.danvega.newsletter.convertkit;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "convertkit")
public record ConvertKitProperties(String url, String apiKey) {

}
