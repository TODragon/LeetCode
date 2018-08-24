package medium;

import java.util.*;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    //先排序，再从小到大合并
    //排序方法用接口，见solution

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> solution = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return solution;

       for(int i = 0; i < intervals.size() - 1; i++) {
            Interval a = intervals.get(i);
            Interval b = intervals.get(i + 1);
            if(a.end >= b. start) {
                b.start = Math.min(a.start, b.start);
                b.end = Math.max(a.end, b.end);
            }
            else solution.add(a);
        }
        solution.add(intervals.get(intervals.size() - 1));
        return solution;
    }
    //solution
    public List<Interval> merge1(List<Interval> intervals) {

        if(intervals == null || intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<>();
        Interval last = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if(curt.start <= last.end) {
                last.end = Math.max(last.end, curt.end);
            }
            else {
                result.add(last);
                last = curt;
            }
        }

        result.add(last);
        return result;
    }
    //实现自定义的比较
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }



    //jiuzhang solution
    // version: 高频题班
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge2(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return ans;
    }

}
