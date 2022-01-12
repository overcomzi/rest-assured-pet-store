package org.example.models.responses;

import io.restassured.response.Response;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class ApiResponse {
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public Duration getTime() {
        return
                Duration.ofMillis(
                        response.getTimeIn(TimeUnit.MILLISECONDS)
                );
    }

    public Response getResponse() {
        return response;
    }
}
