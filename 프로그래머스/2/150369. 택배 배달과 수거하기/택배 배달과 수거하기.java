class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliLast = n;
        int pickLast = n;

        while (deliLast != 0 || pickLast != 0) {
            deliLast = findLastIndex(deliveries, deliLast);
            pickLast = findLastIndex(pickups, pickLast);

            int distance = Math.max(deliLast, pickLast);

            answer += distance * 2;

            deliverAndPickUp(deliveries, pickups, cap, deliLast, pickLast);
        }

        return answer;
    }

    private static void deliverAndPickUp(int[] deliveries, int[] pickups, int cap, int deliLast, int pickLast) {
        int nowCap = cap;

        for (int i = deliLast - 1; i >= 0; i--) {
            if (deliveries[i] == 0) continue;

            if (nowCap >= deliveries[i]) {
                nowCap -= deliveries[i];
                deliveries[i] = 0;
            } else {
                deliveries[i] -= nowCap;
                nowCap = 0;
                break;
            }
        }

        nowCap = cap;

        for (int i = pickLast - 1; i >= 0; i--) {
            if (pickups[i] == 0) continue;

            if (nowCap >= pickups[i]) {
                nowCap -= pickups[i];
                pickups[i] = 0;
            } else {
                pickups[i] -= nowCap;
                nowCap = 0;
                break;
            }
        }
    }

    private static int findLastIndex(int[] arr, int lastIndex) {
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (arr[i] > 0) return i + 1;
        }
        return 0;
    }
}
