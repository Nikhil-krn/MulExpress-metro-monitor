package com.practice.kiosk.repositories;

import com.practice.kiosk.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {

}
