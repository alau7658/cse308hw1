package Jotto.services;

import Jotto.domain.Round;

import java.util.List;

public interface RoundService {
    Round addRound(Round round); //adds round *C
    List<Round> getMatchDetails(Integer gameID); //Gets all the rounds for a game by its gameID *R

}