import java.util.*;


/**
 * Created by Turian Ovidiu.
 * This class is responsible for calculation the ranking.
 */
public class AthleteEvaluation {


    public AthleteEvaluation() {
    }


    /**
     * This method takes a list of Athletes and will return an list sorted by ski time result after calculation the shots.
     * @param athletes the list of Athletes.
     * @return list of Athletes sorted by ski time result after calculation the shots.
     */
    public List<Athlete> rankingAthletes(List<Athlete> athletes) {
        calculateShots(athletes);
        evaluateRanking(athletes);
        return athletes;
    }

    /**
     * This method calculate the shots and will add time to the ski time result if it is necessary.
     * @param athletes list of Athletes.
     */
    private void calculateShots(List<Athlete> athletes) {

        Calendar calendar = Calendar.getInstance();

        for (Athlete athlete : athletes) {
            calendar.setTime(athlete.getSkiTimeResult());

            for (char c : athlete.getFirstShootingRange().toCharArray()) {
                if (c == 'o') {
                    calendar.add(Calendar.SECOND, 10);
                    athlete.setSkiTimeResult(calendar.getTime());
                }
            }

            for (char c : athlete.getSecondShootingRange().toCharArray()) {
                if (c == 'o') {
                    calendar.setTime(athlete.getSkiTimeResult());
                    calendar.add(Calendar.SECOND, 10);
                    athlete.setSkiTimeResult(calendar.getTime());
                }
            }

            for (char c : athlete.getThirdShootingRange().toCharArray()) {
                if (c == 'o') {
                    calendar.setTime(athlete.getSkiTimeResult());
                    calendar.add(Calendar.SECOND, 10);
                    athlete.setSkiTimeResult(calendar.getTime());
                }
            }
        }
    }


    /**
     * This method will sort an given list of Athletes by the ski time result.
     * @param athletes the list of Athletes we want to evaluate.
     * @return an sorted list of Athletes.
     */
    private List<Athlete> evaluateRanking(List<Athlete> athletes) {

        Collections.sort(athletes, new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                if (o1.getSkiTimeResult() == null || o2.getSkiTimeResult() == null) {
                    return 0;
                }
                return o1.getSkiTimeResult().compareTo(o2.getSkiTimeResult());
            }
        });
        return athletes;
    }

}
























