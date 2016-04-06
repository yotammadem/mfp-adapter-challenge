package com.acme.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by yotamm on 04/04/16.
 */
public class RESTUtil {

    @Autowired
    RestTemplate restTemplate;

    @Value("${mfp-runtime-url}")
    String mfpRuntimeURL;

    @Value("${mfp-confidential-client-id}")
    String confidentialClientId;

    @Value("${mfp-confidential-client-secret}")
    String confidentialClientSecret;

    ObjectMapper objectMapper = new ObjectMapper();

    public <T> ResponseEntity<T> performRequest(String url, Class<T> responseType, Object entityObj, HttpMethod method, String scope, Object... urlVariables) throws RestClientException, IOException {
        HttpEntity<?> entity = new HttpEntity<Object>(entityObj);
        if (scope != null) {
            String token = getAccessToken(scope);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            entity = new HttpEntity<Object>(entityObj, headers);
        }
        return restTemplate.exchange(mfpRuntimeURL + "/api/adapters/contactListApi" + url, method, entity, responseType, urlVariables);
    }

    public String getAccessToken(String scope) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String auth = confidentialClientId + ":" + confidentialClientSecret;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String( encodedAuth );
        headers.set("Authorization", authHeader);
        HttpEntity<?> entity = new HttpEntity<Object>("grant_type=client_credentials&scope=" +
                scope, headers);
        ResponseEntity<String> tokenResp = restTemplate.exchange(mfpRuntimeURL + "/api/az/v1/token", HttpMethod.POST, entity, String.class);
        Assert.assertEquals(200, tokenResp.getStatusCode().value());

        Map tokenMap = objectMapper.readValue(tokenResp.getBody(), Map.class);
        return (String) tokenMap.get("access_token");
    }
}