package com.suitt.tables.cinemaShow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaShowRepository extends JpaRepository<CinemaShow, Long> {
    @Query(value = "select * from cinema_show where date_and_time > now() order by date_and_time limit :limit", nativeQuery = true)
    List<CinemaShow> nearestCinemaShows(@Param("limit") int limit);
}