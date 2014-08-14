package ru.carrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.carrier.entity.Carrier;

/**
 * Created by efim on 13.08.14.
 */
@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {

}
