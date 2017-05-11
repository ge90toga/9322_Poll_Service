package com.badbanana.poll.api.repository;

import com.badbanana.poll.api.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by langley on 8/5/17.
 */
public interface PollRepository extends JpaRepository<Poll, Long> {

//    List<Poll> findByUsername(String username);

}
