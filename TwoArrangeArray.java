import java.util.ArrayList;
import java.util.List;

public class TwoArrangeArray {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            lists.add(new ArrayList<>(grid[i].length));
            for (int j = 0; j < grid[i].length; j++) {
                lists.get(i).add(grid[i][j]);
            }
        }
        if (k == 0) {
            return lists;
        }
        lists.add(lists.remove(1));
        if (k == 1) {
            return lists;
        }
        k = k % (lists.size() * lists.get(0).size());

    }
}
