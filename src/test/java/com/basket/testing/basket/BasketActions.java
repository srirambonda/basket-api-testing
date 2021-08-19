package com.basket.testing.basket;

import com.basket.testing.WebServiceEndPoints;
import com.basket.testing.utils.TestStorage;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class BasketActions {

    @Step("Post new Basket")
    public void postNewBasket(String basketName) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body("")
                .when()
                .post(WebServiceEndPoints.BASKET.getUrl() + "/"+basketName);
        if(SerenityRest.lastResponse().statusCode() == 201) {
            String authorisationCode =  SerenityRest.lastResponse().getBody().as(Map.class).get("token").toString();
            TestStorage.setKeyValue(basketName,authorisationCode);
        }
    }

    @Step("Get Basket")
    public void getBasketDetails(String basketName) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization",TestStorage.getKeyValue(basketName))
                .when()
                .get(WebServiceEndPoints.BASKET.getUrl() + "/"+basketName);
    }

    @Step("Delete Basket")
    public void deleteBasket(String basketName) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization",TestStorage.getKeyValue(basketName))
                .when()
                .delete(WebServiceEndPoints.BASKET.getUrl() + "/"+basketName);
    }

    @Step("Update Basket")
    public void updateBasket(String basketName,String basket) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization",TestStorage.getKeyValue(basketName))
                .body(basket)
                .when()
                .put(WebServiceEndPoints.BASKET.getUrl() + "/"+basketName);
    }

}
