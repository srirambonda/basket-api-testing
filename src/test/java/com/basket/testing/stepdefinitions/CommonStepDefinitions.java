package com.basket.testing.stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CommonStepDefinitions {

    @Then("status of response is {int}")
    public void status_of_response_is(Integer responseCode) {
        restAssuredThat(response -> response.statusCode(responseCode));
    }

    @Then("the response content is json")
    public void the_response_content_is_json() {
        String contentType = lastResponse().getContentType();
        Assert.assertEquals(contentType.contains("json"),true);
    }

}
