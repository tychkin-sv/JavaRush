package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
       // System.out.println(1);
        if (o == null) return false;
        //System.out.println(2);

        if (!(o instanceof Solution)) return false;
        //System.out.println(3);
        if (this == o) return true;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        //System.out.println(4);

        //System.out.println(solution + "   " + solution1.solution);
        //System.out.println(solution != null);
        //System.out.println(solution1.solution != null);
        //System.out.println(solution != null ? !solution.equals(solution1.solution) : solution1.solution == null);
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        //System.out.println(5);
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Date date = new Date();
        Solution solution = new Solution(10, "10", 10.0, date, null);
        Solution solutionNew = new Solution(10, "10", 10.0, date, null);
        Solution solution1 = new Solution(10, "10", 10.0, date, solution);
        Solution solution2 = new Solution(10, "10", 10.0, date, solution);
        //System.out.println(solution1.hashCode());
        //System.out.println(solution2.hashCode());
        System.out.println(solution1.equals(solution2));
        System.out.println(solution.equals(solutionNew));
        //System.out.println(solution1 instanceof SolutionOr);
        //System.out.println(solution2 instanceof SolutionOr);


    }
}
