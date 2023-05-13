package com.pandurang.ipldashboard;

import com.pandurang.ipldashboard.config.RawMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomItemProcessor implements ItemProcessor<RawMatch, Match> {

    public static final Logger log = LoggerFactory.getLogger(CustomItemProcessor.class);

    @Override
    public Match process(RawMatch item) throws Exception {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        final Long id = Long.valueOf(item.getId());
        final String city = item.getCity();
        final Date date = new Date(sdf1.parse(item.getDate()).getTime());
        final String season = item.getSeason();
        final String matchNumber = item.getMatchNumber();
        final String team1 = item.getTeam1();
        final String team2 = item.getTeam2();
        final String venue = item.getVenue();
        final String tossWinner = item.getTossWinner();
        final String tossDecision = item.getTossDecision();
        final String superOver = item.getSuperOver();
        final String winningTeam = item.getWinningTeam();
        final String wonBy = item.getWonBy();
        final String margin = item.getMargin();
        final String method = item.getMethod();
        final String playerOfMatch = item.getPlayerOfMatch();
        final String team1Players = item.getTeam1Players();
        final String team2Players = item.getTeam2Players();
        final String umpire1 = item.getUmpire1();
        final String umpire2 = item.getUmpire2();
        Match match = new Match(id, city, date, season, matchNumber, team1, team2, venue, tossWinner, tossDecision, superOver, winningTeam, wonBy, margin, method, playerOfMatch, team1Players, team2Players, umpire1, umpire2);
        log.info(match.toString());
        return match;
    }
}
