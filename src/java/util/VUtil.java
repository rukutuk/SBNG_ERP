/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import constant.UIConstants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Tata
 */
public class VUtil {
    // -------------------------------- STRING MANIPULATOR -------------------------
    /*
     * it will do substring, with extra safe mode
     * null pointer will not throw NullPointerException, but will return null value
     * string with index out of bond will not throw Exception, it will return original string
     */
    public static String substrSafe(String input, int from, int to) {
        if (input == null) {
            return null;
        }
        if (from >= input.length() || from > to) {
            return null;
        }
        if (from < 0) {
            from = 0;
        }
        if (to > input.length()) {
            return input.substring(from, input.length());
        }
        return input.substring(from, to);
    }

    /*
     * Trim a string, but return null if param is null
     */
    public static String trimSafe(String input) {
        if (input == null) {
            return null;
        } else {
            return input.trim();
        }
    }
    
    
    /*
     * Manipulate an input string
     * pattern with '?' will be replace with parameter
     * ex: Do ? with ?
     * getMsg(input, "programming", "code", "book")
     * will produce Do programming with code, but the entire left param will throw away
     */
    public static String getMsg(String pattern, Object... param) {
        int processed = 0;
        int index;
        int from = 0;
        StringBuilder result = new StringBuilder();
        while (processed < param.length) {
            index = pattern.indexOf('?', from);
            if (index != -1) {
                result.append(pattern.substring(from, index));
                if (param[processed] != null) {
                    if (param[processed] instanceof String
                            || param[processed] instanceof Integer
                            || param[processed] instanceof BigInteger
                            || param[processed] instanceof BigDecimal
                            || param[processed] instanceof Short) {
                        result.append(param[processed]);
                    } else if (param[processed] instanceof Date) {
                        result.append(DateUtil.dateToStdCustomLiteral((Date) param[processed], UIConstants.DateFormat.DD_MM_YYYY));
                    }
                } else {
                    result.append("-");
                }
                from = index + 1;
                processed++;
            } else {
                break;
            }
        }
        result.append(pattern.substring(from));
        return result.toString();
    }
    
    /*
     * Manipulate an input string
     * pattern with '?' will be replace with parameter
     * ex: Do ? with ?
     * getMsg(input, "programming", "code", "book")
     * will produce Do programming with code, but the entire left param will throw away
     */
    public static List<String> splitByLineBreak(String input) {
        int index;
        int from = 0;
        int to = 0;
        List<String> result = new ArrayList<String>();
        if (input != null) {
            while (true) {
                index = input.indexOf('\n', from);
                if (index != -1) {
                    to = index;
                    result.add(substrSafe(input, from, to));
                    from = to + 1;
                } else {
                    to = input.length();
                    if (from < to) { 
                        result.add(substrSafe(input, from, to));
                    }
                    break;
                }
            }
        }
        return result;
    }
    
    /*
     * Buang simbol-simbol dari string
     * Hanya menerima angka dan huruf
     */
    public static String fi_zap(String pNoDok) {
        if (VUtil.isNullOrEmpty(pNoDok)) {
            return pNoDok;
        }
        //// using regex--------------
        //String pattern = ".*[\\W].*"; // not (a-z, A-Z, white-space, 0-9)
        //StringBuilder temp = new StringBuilder();
        //for (int i = 0; i < noDok.length(); i++) {
        //    String oneChar = String.valueOf(noDok.charAt(i));
        //    if (oneChar.matches(pattern)) {
        //        continue;
        //    }
        //    temp.append(oneChar);
        //}
        //return temp.toString();

        // using switch ------------
        String retVal = pNoDok;
        try {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < pNoDok.length(); i++) {
                switch (pNoDok.charAt(i)) {
                    case '~':
                    case ' ':
                    case '`':
                    case '!':
                    case '@':
                    case '#':
                    case '$':
                    case '%':
                    case '^':
                    case '&':
                    case '*':
                    case '(':
                    case ')':
                    case '_':
                    case '-':
                    case '+':
                    case '=':
                    case '/':
                    case '\\':
                    case '.':
                    case ',':
                    case ';':
                    case ':':
                    case '\'':
                    case '"':
                    case '|':
                    case '?':
                    case '>':
                    case '<':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        continue;
                    default:
                        temp.append(pNoDok.charAt(i));
                }
            }
            retVal = temp.toString();
        } catch (Exception e) {
        }
        return retVal;
    }
// -------------------------------- NVL REPLACE PARAM --------------------------
    /*
     * Return the value with dash if an input is null
     */
    public static String nvlDash(String input) {
        if (input == null || input.isEmpty()) {
            return "-";
        }
        return input;
    }

    public static <T> T nvl(T input, T replacement) {
        if (input == null) {
            return replacement;
        }
        return input;
    }
    
// -------------------------------- NVL REPLACE WITH ZERO ----------------------
    /*
     * Return the value with zero value if an input is null
     */
    public static BigDecimal nvlZero(BigDecimal input) {
        if (input == null) {
            return BigDecimal.ZERO;
        }
        return input;
    }

    public static String nvlPercent(Integer input) {
        if (input == null) {
            return "%";
        }
        return FormatUtil.formatDataTypeToString(input);
    }

    public static String nvlPercent(String input) {
        if (input == null || (input != null && input.equalsIgnoreCase(""))) {
            return "%";
        }
        return input;
    }

    /*
     * Return the value with zero value if an input is null
     */
    public static BigInteger nvlZero(BigInteger input) {
        if (input == null) {
            return BigInteger.ZERO;
        }
        return input;
    }

    /*
     * Return the value with zero value if an input is null
     */
    public static String nvlZero(String input) {
        if (isNullOrEmpty(input)) {
            return "0";
        }
        return input;
    }

    /*
     * Return the value with zero value if an input is null
     */
    public static Integer nvlZero(Integer input) {
        if (input == null) {
            return 0;
        }
        return input;
    }

    /*
     * Return the value with zero value if an input is null
     */
    public static Short nvlZero(Short input) {
        if (input == null) {
            return 0;
        }
        return input;
    }

// -------------------------------- MATH OPERATION -----------------------------
    /*
     * Truncate decimal to exact point decimal
     */
    public static BigDecimal trunc(BigDecimal val, int point) {
        if (val == null) {
            return null;
        }
        return val.setScale(point, RoundingMode.FLOOR);
    }

    /*
     * Floor the input value
     */
    public static BigDecimal floor(BigDecimal val) {
        if (val == null) {
            return null;
        }
        return val.setScale(0, RoundingMode.FLOOR);
    }

    /*
     * Ceil the input value
     */
    public static BigDecimal ceil(BigDecimal val) {
        if (val == null) {
            return null;
        }
        return val.setScale(0, RoundingMode.CEILING);
    }

    /*
     * Round the input value, with extra caution that 3.5 will round up to 4
     */
    public static BigDecimal round(BigDecimal val) {
        if (val == null) {
            return null;
        }
        return val.setScale(0, RoundingMode.HALF_UP);
    }

// -------------------------------- CHECK OPERATION ----------------------------
    /*
     * Check if the input value is in the list given by second parameter
     */
    public static boolean isInList(String value, String[] list) {
        if (value == null) {
            return false;
        }
        for (String item : list) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Check if the input value is not in the list given by second parameter
     */
    public static boolean isNotInList(String value, String[] list) {
        return !isInList(value, list);
    }

    /*
     * Check if the input value is null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
     * Check if the input value is null or empty
     */
    public static boolean isNullOrEmpty(Map value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
     * Check if the input value is not null or not empty
     */
    public static boolean isNullOrEmpty(List value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
     * Check if the input value, safe mode. The null first parameter value
     * will not throw NullPointerException
     */
    public static boolean eqSafe(String first, String second) {
        if (first == null && second == null) {
            return true;
        } else if (first != null && second != null && first.equals(second)) {
            return true;
        }
        return false;
    }
    
    /*
     * Check if the input value, safe mode. The null first parameter value
     * will not throw NullPointerException
     */
    public static boolean eqSafe(Integer first, Integer second) {
        if (first == null && second == null) {
            return true;
        } else if (first != null && second != null && (first.intValue() == second.intValue())) {
            return true;
        }
        return false;
    }

// -------------------------------- TIME/CALENDER ------------------------------
    /*
     * Trunc the date, only date will be return (h:m:s will be throw away)
     */
    public static Date trunc(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(date);
        return trunc(cal).getTime();
    }

    /*
     * Trunc the date, only date will be return (h:m:s will be throw away)
     */
    private static Calendar trunc(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    /*
     * Add day with second param
     */
    public static Date addDay(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, i);
        return cal.getTime();
    }

    public static int instr(String opr1, String opr2) {
        int instr = opr1.toUpperCase().indexOf(opr2.toUpperCase());
        return instr;
    }

    public static String replace(String opr1, String opr2, String opr3) {
        String strReplace = opr1.toUpperCase().replace(opr2.toUpperCase(), opr3.toUpperCase());
        return strReplace;
    }

    public static BigInteger Mod(BigInteger opr1, BigInteger opr2) {
        BigInteger hasilMod = opr1.mod(opr2);
        return hasilMod;
    }

    public static BigDecimal ribuan(BigDecimal value) {
        if (value == null) {
            return null;
        }
        try {
            BigDecimal nilai = null;
            BigDecimal ratusan = null;

            value = VUtil.ceil(value);

            if (value.compareTo(BigDecimal.ZERO) == -1) {
                return value;
            } else if (value.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            } else if (value.compareTo(new BigDecimal(1000)) != 1) {
                return new BigDecimal(1000);
            } else {
                String strValue = value.toString();
                BigDecimal newVal = new BigDecimal(strValue.substring(strValue.length() - 3));
                if (newVal.compareTo(BigDecimal.ZERO) != 0) {
                    ratusan = (new BigDecimal(1000)).subtract(newVal);
                    nilai = VUtil.ceil(VUtil.nvlZero(value)).add(ratusan);
                } else {
                    return value;
                }
            }
            return nilai;
        } catch (Exception e) {
            return value;
        }
    }
    
    public static boolean IN(String str, String strArrMerge) {
        StringTokenizer token = new StringTokenizer(strArrMerge, ",");
        List<String> list = new ArrayList<String>();
        while (token.hasMoreTokens()) {
            list.add(token.nextToken());
        }
        return in(str, list);
    }

    public static boolean in(String str, List<String> list) {
        boolean isIN = false;

        if (str != null && list != null) {
            for (String arr : list) {
                if (arr.equalsIgnoreCase(str)) {
                    isIN = true;
                    break;
                }
            }
        }
        return isIN;
    }

    public static boolean in(String str, String[] strArr) {
        boolean isIN = false;

        if (str != null && strArr != null) {
            for (String arr : strArr) {
                if (arr.equalsIgnoreCase(str)) {
                    isIN = true;
                    break;
                }
            }
        }
        return isIN;
    }    
    
}
