package sorting;

import java.util.*;


/**
 * Find the minimum number of swaps to sort an Array.
 */

public class MinSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            GfG g = new GfG();
            System.out.println(g.minSwaps(a, n));
        }
    }
}

/*Complete the function*/
class GfG
{
    public static int minSwaps(int[] A, int N) {

        int[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> sortedPos = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            sortedPos.put(sorted[i], i);
        }

        int[] newPos = new int[sorted.length];
        for (int i = 0; i < A.length; i++) {
            newPos[i] = sortedPos.get(A[i]);
        }

        //find cycles
        boolean[] visited = new boolean[sorted.length];
        List<Integer> cycles = new ArrayList<>();
        for (int i = 0; i < newPos.length; i++) {
            if (newPos[i] != i && !visited[i]) {
                int j = i;
                int cycleSize = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = newPos[j];
                    cycleSize++;
                }

                cycles.add(cycleSize);
            }
        }

        int swaps = 0;
        for (Integer i : cycles) {
            swaps += (i - 1);
        }

        return swaps;
    }
}
