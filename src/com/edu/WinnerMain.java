package com.edu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class WinnerMain {


	    public static void main(String args[]) {
	        // Filter and Map -
	        List<String> winnersOfToursLessThan3500km = com.edu.Winner.tdfWinners
	                                                        .stream()
	                                                        .filter(d -> d.getLengthKm() < 3500) // Separate out Tours less than 3500km
	                                                        .map(Winner::getName) // Get names of winners
	                                                        .collect(Collectors.toList()); // Return a list
	        // Winners of Tours Less than 3500km - [Alberto Contador, Cadel Evans, Bradley Wiggins, Chris Froome, Chris Froome]        
	        System.out.println("Winners of Tours Less than 3500km - " + winnersOfToursLessThan3500km);
	        List<String> winnersOfToursGreaterThan3500km = com.edu.Winner.tdfWinners
	                                                         .stream()
	                                                         .filter(d -> d.getLengthKm() >= 3500)
	                                                         .map(Winner::getName)
	                                                         .collect(Collectors.toList());
	        // Winners of Tours Greater than 3500km - [Óscar Pereiro, Alberto Contador, Carlos Sastre, Andy Schleck, Vincenzo Nibali, Chris Froome]
	        System.out.println("Winners of Tours Greater than 3500km - " + winnersOfToursGreaterThan3500km);
	        
	        // limit -
	        List<Winner> winnerObjectsOfToursLessThan3500kmLimit2 = com.edu.Winner.tdfWinners
	                                                                  .stream()
	                                                                  .filter(d -> d.getLengthKm() < 3500)
	                                                                  .limit(2)
	                                                                  .collect(Collectors.toList());
	        // winnerObjectsOfToursLessThan3500kmLimit2 [Alberto Contador, Cadel Evans]
	        System.out.println("winnerObjectsOfToursLessThan3500kmLimit2 " + winnerObjectsOfToursLessThan3500kmLimit2);
	        
	        List<String> firstTwoWinnersOfToursLessThan3500km = com.edu.Winner.tdfWinners
	                                                              .stream()
	                                                              .filter(d -> d.getLengthKm() < 3500)
	                                                              .map(Winner::getName)
	                                                              .limit(2)
	                                                              .collect(Collectors.toList());
	        // firstTwoWinnersOfToursLessThan3500km - [Alberto Contador, Cadel Evans]
	        System.out.println("firstTwoWinnersOfToursLessThan3500km - " + firstTwoWinnersOfToursLessThan3500km);
	        // filter by distinct
	        List<String> distinctTDFWinners = com.edu.Winner.tdfWinners
	                                             .stream()
	                                             .map(Winner::getName)
	                                             .distinct()
	                                             .collect(Collectors.toList());
	        System.out.println("distinctTDFWinners - " + distinctTDFWinners);
	        
	        
	        long numberOfDistinceWinners = com.edu.Winner.tdfWinners
	                                          .stream()
	                                          .map(Winner::getName)
	                                          .distinct()
	                                          .count();
	        // numberOfDistinceWinners - 8
	        System.out.println("numberOfDistinceWinners - " + numberOfDistinceWinners);
	        
	        // skip records
	        List<Winner> skipEveryOtherTDFWinner = com.edu.Winner.tdfWinners
	                                                 .stream()
	                                                 .skip(2)
	                                                 .collect(Collectors.toList());
	        // skipEveryOtherTDFWinner - [Carlos Sastre, Alberto Contador, Andy Schleck, Cadel Evans, Bradley Wiggins, Chris Froome, Vincenzo Nibali, Chris Froome, Chris Froome]
	        System.out.println("skipEveryOtherTDFWinner - " + skipEveryOtherTDFWinner);
	        
	        List<String> mapWinnerYearNamesToList = com.edu.Winner.tdfWinners
	                                                   .stream()
	                                                   .map(w -> w.getYear() + " - " + w.getName())
	                                                   .collect(Collectors.toList());
	        // mapWinnerYearNamesToList [2006 - Óscar Pereiro, 2007 - Alberto Contador, 2008 - Carlos Sastre, 2009 - Alberto Contador, 2010 - Andy Schleck, 2011 - Cadel Evans, 2012 - Bradley Wiggins, 2013 - Chris Froome, 2014 - Vincenzo Nibali, 2015 - Chris Froome, 2016 - Chris Froome]
	        System.out.println("mapWinnerYearNamesToList " + mapWinnerYearNamesToList);
	        
	        List<Integer> mapWinnerNameLengthToList = com.edu.Winner.tdfWinners
	                                                    .stream()
	                                                    .map(Winner::getName)
	                                                    .map(String::length)
	                                                    .collect(Collectors.toList());
	        // mapWinnerNameLengthToList [13, 16, 13, 16, 12, 11, 15, 12, 15, 12, 12]
	        System.out.println("mapWinnerNameLengthToList " + mapWinnerNameLengthToList);
	        
	        
	        // matching - allMatch, noneMatch
	        Optional<Winner> winner2012 = com.edu.Winner.tdfWinners.stream()
	        		 .filter(w -> w.getName().contains("Wiggins")).findAny();
	        // winner2012 - Bradley Wiggins
	        System.out.println("winner2012 -  *****  " + winner2012.get());
	        
	        
	        Optional<Integer> winnerYear2014 = com.edu.Winner.tdfWinners.stream().map(Winner::getYear).filter(x -> x == 2014).findFirst();
	        // winnerYear2014 - 2014
	        System.out.println("winnerYear2014 - " + winnerYear2014.get());
	        
	        
	        // reducing - 0 --> initial value
	        int totalDistance = com.edu.Winner.tdfWinners.stream().map(Winner::getLengthKm).reduce(0, Integer::sum);
	        // totalDistance - 38767
	        System.out.println("totalDistance - " + totalDistance);
	        
	        Optional<Integer> shortestYear = com.edu.Winner.tdfWinners.stream().map(Winner::getLengthKm).reduce(Integer::min);
	        // shortestYear - 3360
	        System.out.println("shortestYear - " + shortestYear.get());
	        
	        Optional<Integer> longestYear = com.edu.Winner.tdfWinners.stream().map(Winner::getLengthKm).reduce(Integer::max);
	        // longestYear - 3661
	        System.out.println("longestYear - " + longestYear.get());
	        
	        Optional<Winner> fastestWinner = com.edu.Winner.tdfWinners.stream().min(Comparator.comparingDouble(Winner::getAveSpeed));
	        System.out.println("fastestTDF - " + fastestWinner.get());
	        
	        // shorthand
	        OptionalDouble fastestTDF = com.edu.Winner.tdfWinners.stream().mapToDouble(Winner::getAveSpeed).min();
	        // fastestTDF - 39.0
	        System.out.println("fastestTDF - " + fastestTDF.getAsDouble());
	        
	        
	        // groupingby - make a map whose keys are names
	        Map<String, List<Winner>> namesVsWinner = com.edu.Winner.tdfWinners.stream().collect(Collectors.groupingBy(Winner::getName));
	        // namesVsWinner - {Bradley Wiggins=[Bradley Wiggins], Carlos Sastre=[Carlos Sastre], Cadel Evans=[Cadel Evans], Óscar Pereiro=[Óscar Pereiro], Chris Froome=[Chris Froome, Chris Froome, Chris Froome], Andy Schleck=[Andy Schleck], Alberto Contador=[Alberto Contador, Alberto Contador], Vincenzo Nibali=[Vincenzo Nibali]}
	        System.out.println("namesVsWinner - " + namesVsWinner);
	        // join strings
	        String allTDFWinnersTeamsCSV = com.edu.Winner.tdfWinners.stream().map(Winner::getTeam).collect(Collectors.joining(", "));
	        // allTDFWinnersTeams Caisse d'Epargne–Illes Balears, Discovery Channel, Team CSC, Astana, Team Saxo Bank, BMC Racing Team, Team Sky, Team Sky, Astana, Team Sky, Team Sky
	        System.out.println("allTDFWinnersTeams " + allTDFWinnersTeamsCSV);
	        // grouping
	        Map<String, List<Winner>> winnersByNationality = com.edu.Winner.tdfWinners.stream().collect(Collectors.groupingBy(Winner::getNationality));
	        // winnersByNationality - {Great Britain=[Bradley Wiggins, Chris Froome, Chris Froome, Chris Froome], Luxembourg=[Andy Schleck], Italy=[Vincenzo Nibali], Australia=[Cadel Evans], Spain=[Óscar Pereiro, Alberto Contador, Carlos Sastre, Alberto Contador]}
	        System.out.println("winnersByNationality - " + winnersByNationality);
	        Map<String, Long> winsByNationalityCounting = com.edu.Winner.tdfWinners.stream().collect(Collectors.groupingBy(Winner::getNationality, Collectors.counting()));
	        // winsByNationalityCounting - {Great Britain=4, Luxembourg=1, Italy=1, Australia=1, Spain=4}
	        System.out.println("winsByNationalityCounting - " + winsByNationalityCounting);
	        
	        List l = com.edu.Winner.tdfWinners.stream().filter(w -> w.getYear() >1999).sequential().collect(Collectors.toList());
	        System.out.println(" *** l ***"+l);
	    }
}
