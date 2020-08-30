package day0826;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sInput = in.next();
        try {
            String[] widthStr = sInput.substring(1, sInput.length() / 2 - 1).split(",");
            String[] heightStr = sInput.substring(sInput.length() / 2 + 2, sInput.length() - 1).split(",");
            ArrayList<Integer> heightArr = new ArrayList<>();
            for (int i = 0; i < widthStr.length; i++) {
                int width = Integer.parseInt(widthStr[i]);
                int height = Integer.parseInt(heightStr[i]);
                for (int j = 0; j < width; j++) {
                    heightArr.add(height);
                }
            }
            System.out.println(maxArea(heightArr));
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }

    private static int maxArea(List<Integer> heights) {
        if (heights.size() == 1) {
            return heights.get(0);
        }
        if (heights.size() == 0) {
            return 0;
        }
        int res = 0;
        int minIndex = 0;
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i) < heights.get(minIndex)) {
                minIndex = i;
            }
        }
        List<Integer> leftArr = heights.subList(0, minIndex);
        List<Integer> rightArr = heights.subList(minIndex + 1, heights.size());
        int acrossArea = heights.size() * heights.get(minIndex);
        int leftMax = maxArea(leftArr);
        int rightMax = maxArea(rightArr);
        res = Math.max(leftMax, acrossArea);
        res = Math.max(rightMax, res);
        return res;
    }
}
