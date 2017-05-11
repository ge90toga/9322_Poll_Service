
package com.badbanana.poll.api.tool;

import com.badbanana.poll.api.model.Poll;
import com.badbanana.poll.api.model.Vote;
import com.badbanana.poll.api.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * initial data at application startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PollRepository pollRepository;

    @Override
    public void run(String... arg0) throws Exception {
//        insertPoll();
    }

    private void insertPoll() {
        Poll poll = new Poll();
        poll.setTitle("hello");
        poll.setIdentity(IdentityGenerator.generateShortUUID());
        Vote vote = new Vote();
        List<Vote> votes = new ArrayList<>();
        vote.setName("11AM");
        vote.setCount(2);

        votes.add(vote);
        poll.setVotes(votes);

        System.out.println(poll);
        pollRepository.save(poll);


    }


}