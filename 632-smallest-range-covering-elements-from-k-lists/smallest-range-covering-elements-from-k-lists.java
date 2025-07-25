import java.util.*;

class Tuple {
    int data, row, col;
    Tuple(int data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        int max = Integer.MIN_VALUE;

        // Step 1: Push first element of every list into the heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.add(new Tuple(val, i, 0));
            max = Math.max(max, val);
        }

        int start = pq.peek().data;
        int end = max;
        int[] res = new int[]{start, end};

        while (true) {
            Tuple temp = pq.poll();
            int min = temp.data;

            // Update range if smaller
            if (end - start > max - min) {
                start = min;
                end = max;
                res[0] = start;
                res[1] = end;
            }

            // Move to next element in the same list
            if (temp.col + 1 < nums.get(temp.row).size()) {
                int nextVal = nums.get(temp.row).get(temp.col + 1);
                pq.add(new Tuple(nextVal, temp.row, temp.col + 1));
                max = Math.max(max, nextVal);
            } else {
                // One list is exhausted, stop
                break;
            }
        }

        return res;
    }
}
