package com.badbanana.poll.api.controllers;

import com.badbanana.poll.api.model.Poll;
import com.badbanana.poll.api.model.Vote;
import com.badbanana.poll.api.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by langley on 11/5/17.
 */
@RestController
@RequestMapping(value = "/api/vote")
public class VoteController {

    @Autowired
    private PollRepository pollRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Poll> addVote(@RequestParam(value = "identity", required = true) String identity,
                                            @RequestParam(value = "voteName", required = true) String voteName)  {
        Poll poll = pollRepository.findByIdentity(identity);
        for (Vote vote : poll.getVotes()) {
            if (vote.getName().equals(voteName)) {
                vote.setCount(vote.getCount() + 1);
                break;
            }
        }
        pollRepository.save(poll);

        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }

}

