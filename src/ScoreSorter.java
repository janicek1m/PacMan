import java.util.Comparator;
 
public class ScoreSorter implements Comparator<Scorer> {
    @Override
    public int compare(Scorer s1, Scorer s2) {
        return s2.getScore() - s1.getScore();
    }
}