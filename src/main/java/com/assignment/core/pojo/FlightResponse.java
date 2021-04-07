package com.assignment.core.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class FlightResponse extends Response {
    Integer count;
    private FlightResponse(String status, Integer count) {
        this.status = status;
        this.count = count;
    }
    private FlightResponse(String status) {
        this.status = status;
    }

    public static FlightResponse getInstance(String status, Integer count) {
        return new FlightResponse(status, count);
    }
    public static FlightResponse getInstance(String status) {
        return new FlightResponse(status);
    }

}
