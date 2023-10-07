package arrays;

public class MaximumPopulationYear1854 {
    public int maximumPopulation(int[][] logs) {
        int count[] = new int[101];
        int offset = 1950, birthYear, dethYear;
        for (int[] person : logs){
            birthYear = person[0] - offset;
            dethYear = person[1] - offset;
            count[birthYear]++;
            count[dethYear]--;
        }
        int sum=0, max=0, index=0;

        for (int i=0; i<count.length; i++){
            sum += count[i];
            if (sum > max){
                max = sum;
                index =i;
            }
        }
        return index+offset;
    }
}
