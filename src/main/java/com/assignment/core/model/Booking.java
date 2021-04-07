package com.assignment.core.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
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

    @NotNull
    @PrimaryKey
    @Column
    String flightNumber;

    @ClusteringColumn
    @NotNull
    @Column
    String userName;

    @JsonIgnore
    @Column
    Integer seatNumber;

}
