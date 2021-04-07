package com.assignment.core.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Column;
import javax.validation.constraints.NotNull;
@Data
@Builder(toBuilder = true)
@Table("flight")
public class Flight {
    @PrimaryKey
    @NotNull
    String flightNumber;

    @Column
    @NotNull
    Integer noOfSeats;

    @Column
    @JsonIgnore
    Integer availableSeats;
}
