package ru.carrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.carrier.entity.Bus;

/**
 * Created by efim on 13.08.14.
 */
@Repository
public interface BusRepository extends PagingAndSortingRepository<Bus, Long> {

}
