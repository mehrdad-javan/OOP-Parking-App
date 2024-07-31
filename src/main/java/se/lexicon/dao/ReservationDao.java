package se.lexicon.dao;

import se.lexicon.model.Reservation;

import java.util.Optional;

public interface ReservationDao {
    Reservation create(Reservation reservation);

    Optional<Reservation> find(String id);

    // add more methods as needed.
}
