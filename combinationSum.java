import java.util.ArrayList;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		int[] candidates = {2,3,5};
		int target = 8;
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		answer = combinationSum(candidates, target);
		System.out.println(answer);
	}
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
   		ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
   		ArrayList<Integer> solution = new ArrayList<Integer>();
   		helper(candidates, target, solution, solutions, 0);
   		return solutions;
    }
    public static ArrayList<Integer> helper(int[] candidates, int target, ArrayList<Integer> solution, ArrayList<ArrayList<Integer>> solutions, int i) {
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