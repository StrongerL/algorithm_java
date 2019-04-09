package 数学;

import java.util.*;
import java.util.List;
public class 点与多边形 {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/

/*
外部
0,-1
0,0,0,1,1,1,1,0
内部
0.5,0.5
0,0,0,1,1,1,1,0
边上
0.5,0
0,0,0,1,1,1,1,0
*/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {


        // 把第一个点加到最后，最后一条边就不需要单独判断
        xList.add(xList.get(0));
        yList.add(yList.get(0));

        double epsilon = 0.000001;
        int n = xList.size();
        double x1, x2, y1, y2, slope;

        // 判断是否在边上
        for(int i = 0; i < n - 1; i++) {
            x1 = xList.get(i);
            x2 = xList.get(i + 1);
            if ((x >= x1 && x <= x2) || (x >= x2 && x <= x1)) {
                y1 = yList.get(i);
                y2 = yList.get(i + 1);
                // x值相同
                if (Math.abs(x - x1) <= epsilon)
                    if (Math.abs(y - y1) <= epsilon)
                        return "yes,0";
                    else
                        continue;
                if (Math.abs(x - x2) <= epsilon)
                    if (Math.abs(y - y2) < epsilon)
                        return "yes,0";
                    else
                        continue;
                // 判断斜率相等
                if ((y2 - y) / (x2 - x) - (y1 - y) / (x1 - x) <= epsilon) {
                    return "yes,0";
                }

            }
        }

        // 判断是否在多边形内部
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            x1 = xList.get(i);
            x2 = xList.get(i + 1);
            if ((x >= x1 && x <= x2) || (x >= x2 && x <= x1)) {
                y1 = yList.get(i);
                y2 = yList.get(i + 1);
                slope = (y2 - y1) / (x2 - x1);
                if (x1 + slope * (x - x1) > y)
                    count++;
            }
        }

        // 在内部
        if (count % 2 != 0)
            return "yes,0";

        // 在外部，计算最短距离
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            x1 = xList.get(i);
            x2 = xList.get(i + 1);
            y1 = yList.get(i);
            y2 = yList.get(i + 1);

            double a = Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
            double b = Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
            double c = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            double distance = 0;
            if (a * a > b * b + c * c)
                distance = b;
            else if (b * b > a * a + c * c)
                distance = a;
            else{
                double p = (a + b + c) / 2;
                distance = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }
            if (distance < min)
                min = distance;
        }
        return "no," + (int)Math.round(min);

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}