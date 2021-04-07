package com.assignment.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@Table(value = "booking")
public class Booking {
    @PrimaryKey
    @NotNull
    @Column
    String userName;

    @NotNull
    @Column
    String flightNumber;

    @JsonIgnore
    @Column
    Integer seatNumber;

}
