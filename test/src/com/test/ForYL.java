package com.test;

/**
 * Created by ListenYoung on 16/12/8.
 */
public class ForYL {
    public static void main(String[] args){
        int D = 860;
        int d = 430;
        int Le = 330;
        int Lc = 3200;
        int b = 5;

        double a = Math.asin((double)d/D);
        double Ot = Lc * Math.tan(a) / Math.PI / D * 360 + 2 * (90 + Math.asin((2 * Le * Math.tan(a) - d) / D));
        double m = 10000;
        boolean flag = true;
        while (flag){
            for(int n = 1 ; n <= 6 ;  n++){
                for(int k = 1 ; k <= 5 ; k ++){
                    if(!flag){
                    }
                    for(int N = 0 ; N <= 8 ; N ++){
                        double Onk1 = ((double)k / n + N) * 360 + b / (n * Math.PI * D * Math.cos(a)) * 360;
                        double Onk2 = ((double)k / n + N) * 360 - b / (n * Math.PI * D * Math.cos(a)) * 360;

                        double m1 = Math.abs(Onk1 - 2 * Ot);
                        double m2 = Math.abs(Onk2 - 2 * Ot);

                        double temp = m1 > m2 ? m2 : m1;
                        if(temp < m){
                            m = temp;
                        }
                    }
                }
                if(m < 0.001){
                    System.out.println("m = " + m);
                    System.out.println("a = " + a);
                    System.exit(0);
                }
            }

            a += 0.01;
            Ot = Lc * Math.tan(a) / Math.PI / D * 360 + 2 * (90 + Math.asin((2 * Le * Math.tan(a) - d) / D));

        }
    }
}
