package Jotto.services;


import Jotto.domain.Round;
import Jotto.repositories.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Override
    public Round addRound(Round round){
        return roundRepository.save(round);
    }

    @Override
    public List<Round> getMatchDetails(Integer gameID) {
        return roundRepository.getMatchDetails(gameID);
    }




}