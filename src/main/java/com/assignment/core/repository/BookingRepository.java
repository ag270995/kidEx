package com.assignment.core.repository;

import com.assignment.core.model.Booking;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CassandraRepository<Booking, String> {
}
