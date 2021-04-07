package com.assignment.core.repository;

import com.assignment.core.model.Flight;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlightRepository extends CassandraRepository<Flight, String> {

}
