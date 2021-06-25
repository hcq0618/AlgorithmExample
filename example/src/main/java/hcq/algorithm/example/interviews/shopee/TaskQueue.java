package hcq.algorithm.example.interviews.shopee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 输入多个task间的依赖关系，依次输出可以同时被并行执行的task顺序
 * <p>
 * 例如task2和task1被task3依赖，task3和task1被task4依赖，task4和task5被task6，输出[[1, 2, 5], [3], [4], [6]]
 * <p>
 * Created by changqiang.huang on 2021/6/10 16:15
 */
public class TaskQueue {

    public static void main(String[] args) {
        ArrayList<int[]> input = new ArrayList<>();
        input.add(new int[]{1, 3});
        input.add(new int[]{2, 3});
        input.add(new int[]{1, 4});
        input.add(new int[]{3, 4});
        input.add(new int[]{4, 6});
        input.add(new int[]{5, 6});
        System.out.println(solution(input, input.size()));
    }

    private static class Task {
        final Set<Integer> dependedNumbers;
        final Set<Integer> dependencyNumbers;
        final int number;
        boolean isCompleted;

        Task(int number, int taskCount) {
            this.number = number;
            dependedNumbers = new HashSet<>(taskCount);
            dependencyNumbers = new HashSet<>(taskCount);
        }

        void run() {
            isCompleted = true;
        }
    }

    public static List<List<Integer>> solution(List<int[]> input, int taskCount) {
        List<Task> allTasks = new ArrayList<>(taskCount);
        for (int i = 0; i < taskCount; i++) {
            allTasks.add(new Task(i + 1, taskCount));
        }

        for (int[] ints : input) {
            if (ints.length < 2) {
                continue;
            }
            int dependencyIndex = ints[0] - 1;
            int taskIndex = ints[1] - 1;

            if (taskIndex >= taskCount || dependencyIndex >= taskCount) {
                continue;
            }
            Task task = allTasks.get(taskIndex);
            Task dependencyTask = allTasks.get(dependencyIndex);
            task.dependencyNumbers.add(dependencyIndex + 1);
            dependencyTask.dependedNumbers.add(taskIndex + 1);
        }

        int remainTaskCount = taskCount;
        List<List<Integer>> result = new ArrayList<>();
        while (remainTaskCount > 0) {
            List<Integer> group = new ArrayList<>(taskCount);
            for (Task task : allTasks) {
                if (task.isCompleted) {
                    continue;
                }
                if (task.dependencyNumbers.isEmpty()) {
                    task.run();
                    group.add(task.number);
                }
            }

            for (Integer number : group) {
                Task task = allTasks.get(number - 1);
                for (Integer dependedNumber : task.dependedNumbers) {
                    Task dependedTask = allTasks.get(dependedNumber - 1);
                    dependedTask.dependencyNumbers.remove(task.number);
                }
            }
            remainTaskCount -= group.size();
            result.add(group);
        }

        return result;
    }
}
