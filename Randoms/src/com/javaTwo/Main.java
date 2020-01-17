package com.javaTwo;

public class Main {

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

    public static void main(String[] args) {
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
