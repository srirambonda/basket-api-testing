package com.basket.testing.stepdefinitions;

import com.basket.testing.basket.BasketActions;
import com.basket.testing.utils.templates.FieldValues;
import com.basket.testing.utils.templates.MergeFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import com.basket.testing.basket.BasketResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.get;
import static org.assertj.core.api.Assertions.assertThat;

public class BasketStepDefinitions {

    @Steps
    BasketActions basketActions;

    @Steps
    BasketResponse basketResponse;

    String basket;

    @Given("the following basket:")
    public void the_following_order(List<Map<String, String>> basketDetails) throws IOException {

        basket = MergeFrom.template("templates/basket.json")
                         .withDefaultValuesFrom(FieldValues.in("templates/standard-basket.properties"))
                         .withFieldsFrom(basketDetails.get(0));
    }
    @Given("I create new basket with name {string}")
    public void i_create_new_basket_with_name(String basketName) {
        basketActions.postNewBasket(basketName);
    }

    @Then("the basket response should have token")
    public void the_basket_response_should_have_token() {
        assertThat(basketResponse.returned().get("token")).isNotEmpty();
    }

    @When("I update the basket for {string}")
    public void i_update_the_basket_for(String basketName) {
        basketActions.updateBasket(basketName,basket);
    }

    @Given("get the basket details of {string}")
    public void get_the_basket_details_of(String basketName) {
        basketActions.getBasketDetails(basketName);
    }

    @Then("the response should have forward_url value {string}")
    public void the_response_should_have_forward_url_value(String value) {
        assertThat(basketResponse.returned().get("forward_url")).isEqualTo(value);
    }

    @Given("delete the basket details for {string}")
    public void delete_the_basket_details_for(String value) {
        basketActions.deleteBasket(value);
    }
}
