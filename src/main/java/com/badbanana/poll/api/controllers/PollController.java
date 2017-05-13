package com.badbanana.poll.api.controllers;

import com.badbanana.poll.api.DTO.PollDTO;
import com.badbanana.poll.api.model.Poll;
import com.badbanana.poll.api.model.Vote;
import com.badbanana.poll.api.repository.PollRepository;
import com.badbanana.poll.api.tool.IdentityGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by langley on 11/5/17.
 */

@Controller
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @ResponseBody
    @RequestMapping(value = "/api/poll", method = RequestMethod.POST)
    public ResponseEntity<?> addPoll(@RequestBody PollDTO pollDTO, HttpServletRequest request) {
        Poll poll = new Poll();
        String identity = IdentityGenerator.generateShortUUID();
        poll.setIdentity(identity);
        poll.setTitle(pollDTO.getTitle());
        List<Vote> votes = new ArrayList<>();

        System.out.println("pollDTO" + pollDTO);
        for (String option : pollDTO.getPollOptions()) {
            Vote vote = new Vote();
            vote.setName(option);
            votes.add(vote);
        }
        poll.setVotes(votes);
        pollRepository.save(poll);

        String shortURL = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort()
                + "/api/poll/" + identity;

        return new ResponseEntity<>(shortURL, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/api/poll/{identity}", method = RequestMethod.GET)
    public ResponseEntity<?> getPollAPI(@PathVariable String identity) {
        Poll poll = pollRepository.findByIdentity(identity);
        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/poll/{identity}", method = RequestMethod.GET)
    public String getPollPage(@PathVariable String identity, Model model) {
        Poll poll = pollRepository.findByIdentity(identity);
        model.addAttribute("poll", poll);
        return "poll";
    }

}
