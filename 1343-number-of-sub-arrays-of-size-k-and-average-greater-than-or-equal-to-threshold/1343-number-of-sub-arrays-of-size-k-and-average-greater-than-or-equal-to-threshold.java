class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;

        for(int i=0; i<k; i++)
            sum += arr[i];

        int count = sum/k >= threshold ? 1:0;

        for(int i=0; i<arr.length - k; i++){
            sum -= arr[i];
            sum += arr[i+k];

            count += sum/k >= threshold ? 1:0;
        }

        return count;
    }
}