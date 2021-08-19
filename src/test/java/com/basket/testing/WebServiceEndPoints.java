package com.basket.testing;

public enum WebServiceEndPoints {
    BASKET("https://rbaskets.in/api/baskets");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
