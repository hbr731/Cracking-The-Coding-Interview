package com.javaTwo;
/*
https://www.geeksforgeeks.org/find-excel-column-number-column-title/
 */
public class Main {

    // Find Excel column name from a given column number
    public static String getExcelColumnName(Long n) {
        Long copy = n;
        StringBuilder str = new StringBuilder();
        // get the row number
        int row = 1;
        while (copy > 702) {
            copy -= 702;
            row++;
        }

//        System.out.println("column number: " + copy);

        //get the column name
        while (copy-- > 0) {
            if (copy > 26) {
                str.append((char)('A' + (copy % 26)));
                copy /= 26 ;
            } else {
                str.append((char)('A' + copy));
                break;
            }
        }

        str.append(row);

        return str.reverse().toString();
    }

    /*
     Factset- Efficient Janitor problem
    Given weights : [1.99, 1.01, 2.5, 1.5, 1.01]
    Maximum bag size is 3.0 find the minimum number trips required by the janitor to dump the garbage.
    Output for the example :
    [1.01 + 1.99], [1.01 + 1.5], [2.5] so min steps is 3.
     */
    public static int efficientJanitor(Float[] weights) {
        int trips = 0;



        return trips;
    }

    public static void main(String[] args) {
        System.out.println("*/---------------------------------------------------/*");
        System.out.println(getExcelColumnName((long) 26));
        System.out.println(getExcelColumnName((long) 702 + 26));
        System.out.println(getExcelColumnName((long) 702 + 702 +26));
        System.out.println();
        System.out.println(getExcelColumnName((long) 51));
        System.out.println(getExcelColumnName((long) 702+51));
        System.out.println(getExcelColumnName((long) 702+702+51));
        System.out.println();
        System.out.println(getExcelColumnName((long) 52));
        System.out.println(getExcelColumnName((long) 702+52));
        System.out.println(getExcelColumnName((long) 702+702+52));
        System.out.println();
        System.out.println(getExcelColumnName((long) 53));
        System.out.println(getExcelColumnName((long) 702+53));
        System.out.println(getExcelColumnName((long) 702+702+53));
        System.out.println();
        System.out.println(getExcelColumnName((long) 1380));

        System.out.println();
        System.out.println("*/---------------------------------------------------/*");

        System.out.println(efficientJanitor(new Float[]{1.99f, 1.01f, 2.5f, 1.5f, 1.01f}));
        if (Math.abs(.999999999 - 1) < 0.00000001) System.out.println("a = b");
        else System.out.println("a != b");
    }
}

/*  OUTPUT
1Z
2Z
3Z

1AY
2AY
3AY

1AZ
2AZ
3AZ

1BA
2BA
3BA

2ZB
 */
