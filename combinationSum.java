import java.util.ArrayList;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] {2,3,5}, 8));
		System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
   		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
   		List<Integer> solution = new ArrayList<Integer>();
   		helper(candidates, target, solution, solutions, 0);
   		return solutions;
    }
    public static ArrayList<Integer> helper(int[] candidates, int target, List<Integer> solution, List<List<Integer>> solutions, int i) {
    	if(target < 0) {
    		return null;
    	}
    	if(target == 0) {
    		return new ArrayList<Integer>(solution);
    	}
    	for(int j = i; j < candidates.length; j++) {
    		solution.add(candidates[j]);
    		ArrayList<Integer> temp = helper(candidates, target - candidates[j], solution, solutions, j);
    		if(temp != null) {
    			solutions.add(temp);
    		}
    		solution.remove(solution.size()-1);
    	}
    	return null;
    } 
}