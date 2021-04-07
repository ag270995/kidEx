package com.assignment.core.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Response {
    String status;
    String message;

    private Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response getInstance() {
        return new Response();
    }

    public static Response getInstance(String status, String message) {
        return new Response(status, message);
    }
}
