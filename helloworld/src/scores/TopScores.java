package scores;

import java.util.Arrays;
public class TopScores {
    
    //完成 main 方法
    public static void main(String[] args) {
        int[] scores = {89, -23, 64, 91, 119, 52, 73};
        System.out.println("前三名为：");

        TopScores hello = new TopScores();
        hello.showTop(scores);
    }
    
    //定义方法完成成绩排序并输出前三名的功能
    public void showTop(int[] scores) {
        Arrays.sort(scores);
        int num = 0;
        for (int i = scores.length - 1; i >= 0; i --) {
            if (scores[i] < 0 || scores[i] > 100) {
                continue;
            }
            num ++;
            if (num > 3) {
                break;
            }
            System.out.println(scores[i]);
        }
    }
}