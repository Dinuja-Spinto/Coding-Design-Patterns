package codingPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsPattern {
    public List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Step 2: Sort the intervals by their start points
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);

            // Step 4: Check for overlapping
            if (currentInterval.end >= nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                // No overlap, add the current merged interval
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last merged interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }

    public static void main(String[] args) {
        MergeIntervalsPattern mergeIntervalsPattern = new MergeIntervalsPattern();
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> merged = mergeIntervalsPattern.mergeIntervals(intervals);
        for (Interval interval : merged) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
