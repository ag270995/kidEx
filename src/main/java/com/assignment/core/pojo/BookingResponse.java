package com.assignment.core.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class BookingResponse extends Response {
    Integer seatNumber;
    private BookingResponse(String status, Integer seatNumber) {
        this.status = status;
        this.seatNumber = seatNumber;
    }
    public static BookingResponse getInstance(String status, Integer seatNumber) {
        return new BookingResponse(status, seatNumber);
    }

}
