/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;

/**
 *
 * @author Rama
 */
public class StringUtil {

    private static StringUtil util;
    private final String PEMBAGI_SEPULUH = "10";
    private final String PEMBAGI_SERATUS = "100";
    private final String PEMBAGI_SERIBU = "1000";
    private final String PEMBAGI_SEJUTA = "1000000";
    private final String PEMBAGI_SEMILYAR = "1000000000";
    private final String PEMBAGI_SETRILYUN = "1000000000000";

    public static StringUtil getInstance() {
        if (util == null) {
            util = new StringUtil();
        }
        return util;
    }

    /*
     * @Author Servicer
     * pengecekan String kalau null 
     * return value true
     * kalo empty
     * return null
     * kalo ada isinya kembaliannya false
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isListNotEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    /* REPLACED WITH rtrim(String str)
    public static String rightTrim(String data) {
    if (data == null) {
    return null;
    }
    
    char[] arr = data.toCharArray();
    StringBuilder s = new StringBuilder();
    char[] newArr = new char[1];
    int pos = 0;
    //worst algorithm ever. but works!
    for (int i = 0; i < arr.length; i++) {
    pos = (arr.length - 1) - i;
    // PrintWrapper.print("pos["+pos+"] i["+i+"] ["+arr[pos]+"]");
    if (arr[pos] != ' ') {
    newArr = new char[pos + 1];
    System.arraycopy(arr, 0, newArr, 0, pos + 1);
    break;
    }
    
    }
    
    return new String(newArr);
    }
     */
    public static String padTrim(String str, int size) {
        return String.format("%-" + size + "s", str).substring(0, size);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return " ";
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str.substring(0, (str.length() - Math.abs(pads))); // returns original String with substring
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return repeat(padChar, pads).concat(str);
    }

    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return " ";
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str.substring(0, (str.length() - Math.abs(pads))); // returns original String with substring
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return " ";
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str.substring(0, (str.length() - Math.abs(pads))); // returns original String with substring
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(repeat(padChar, pads));
    }

    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return " ";
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str.substring(0, (str.length() - Math.abs(pads))); // returns original String with substring
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    public static BigDecimal toBigDecimal(String str) {
        if (!str.isEmpty()) {
            return new BigDecimal(str);
        }
        return null;
    }

    public static BigDecimal toBigDecimalThenDivideBy(String str, String divisor) {
        if (!str.isEmpty()) {
            return (new BigDecimal(str)).divide(new BigDecimal(divisor));
        }
        return null;
    }

    public static BigInteger toBigInteger(String str) {
        if (!str.isEmpty()) {
            return new BigInteger(str);
        }
        return null;
    }

    public static Long toLong(String str) {
        if (!str.isEmpty()) {
            return new Long(str);
        }
        return null;
    }

    public static Integer toInteger(String str) {
        if (!str.isEmpty()) {
            return new Integer(str);
        }
        return null;
    }

    public static Short toShort(String str) {
        if (!str.isEmpty()) {
            return new Short(str);
        }
        return null;
    }

    public static String returnNullIfEmpty(String str) {
        if (!str.isEmpty()) {
            return str;
        }
        return null;
    }

    /*
     * DO NOT ERASE!
     * 
     */
//    static public String format(String format, Object... args) {
//        String buff = format;
//        int imax = args.length;
//        for (int i = 0; i < imax; i++) {
//            buff = buff.replaceAll("\\{" + i + "}", String.valueOf(args[i]));
//        }
//        return buff.replaceAll("\\{\\d}", "");
//    }
    public static void printMapContent(Map<String, Object> map) {
        if (map != null) {
            List<String> ls = new ArrayList<String>();
            PrintWrapper.print("------------------------------------------");
            PrintWrapper.print("----------  Print Map Content  -----------");
            PrintWrapper.print("------------------------------------------");
            PrintWrapper.print(" number | Keys | | Val | ");
            PrintWrapper.print("-----------------------------------------");
            Set set = map.keySet();
            Iterator it = set.iterator();
            Object[] la = set.toArray();
            for (int a = 0; a < la.length; a++) {

                PrintWrapper.print("| " + a + "  |  " + la[a].toString() + "  |  " + map.get(it.next()) + "  |  ");
            }
            PrintWrapper.print("-----------------------------------------");
        }
    }

    public static void printMapContent(Map<String, Object> map, Logger logger) {
        if (map != null) {
            List<String> ls = new ArrayList<String>();
            logger.info("------------------------------------------");
            logger.info("----------  Print Map Content  -----------");
            logger.info("------------------------------------------");
            logger.info(" number | Keys | | Val | ");
            logger.info("-----------------------------------------");
            Set set = map.keySet();
            Iterator it = set.iterator();
            Object[] la = set.toArray();
            for (int a = 0; a < la.length; a++) {

                logger.info("| " + a + "  |  " + la[a].toString() + "  |  " + map.get(it.next()) + "  |  ");
            }
            logger.info("-----------------------------------------");
        }

    }
    private static final int PAD_LIMIT = 8192;

    public static String ltrim(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().equals("")) {
            return "";
        }

        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
        }

        return str.substring(i);
    }

    public static String rtrim(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().equals("")) {
            return "";
        }

        int i = str.length() - 1;
        while (str.charAt(i) == ' ') {
            i--;
        }

        return str.substring(0, i + 1);
    }

    public BigInteger convertStringToBigInteger(String str) {
        try {
            BigDecimal bd = new BigDecimal(str);
            return bd.toBigInteger();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return BigInteger.ZERO;
    }

    public static void main(String[] args) {
        int a = 1234567890;
        BigInteger b = new BigInteger("12345678901234567890");
        PrintWrapper.print("a = " + a);
        PrintWrapper.print("b = " + b);
        PrintWrapper.print("c = " + b.intValue());
    }

    //begin of converter decimal to nominal
    public String getTerbilang(BigDecimal dataUang) {
        final String CONST_SPASI = " ";
        final String CONST_NOL = "0";
        final String CONST_11 = "11";
        final String CONST_19 = "19";
        final String CONST_99 = "99";
        final String CONST_199 = "199";
        final String CONST_999 = "999";
        final String CONST_1999 = "1999";
        final String CONST_999_RIBU = "999999";
        final String CONST_999_JUTA = "999999999";
        final String CONST_999_MILYAR = "999999999999";
        final String CONST_999_TRILYUN = "999999999999999";
        StringBuilder result = new StringBuilder();
        int satuan;

        //cek apakah data minus
        if (dataUang.compareTo(BigDecimal.ZERO) < 0) {
            dataUang = dataUang.multiply(BigDecimal.ONE.negate());
            result.append("Minus");

        }

        // data dianggap tidak minus
        if (cekData(dataUang, CONST_NOL, CONST_11)) {
            result.append(CONST_SPASI).append(getSatuan(dataUang.intValue()));
        } else if (cekData(dataUang, CONST_11, CONST_19)) {
            result.append(getTerbilang(mod(dataUang, PEMBAGI_SEPULUH))).append(CONST_SPASI).append("Belas");
        } else if (cekData(dataUang, CONST_19, CONST_99)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SEPULUH))).append(CONST_SPASI).append("Puluh").append(getTerbilang(mod(dataUang, PEMBAGI_SEPULUH)));
        } else if (cekData(dataUang, CONST_99, CONST_199)) {
            result.append(CONST_SPASI).append("Seratus").append(getTerbilang(dataUang.subtract(new BigDecimal(PEMBAGI_SERATUS))));
        } else if (cekData(dataUang, CONST_199, CONST_999)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SERATUS))).append(CONST_SPASI).append("Ratus").append(getTerbilang(mod(dataUang, PEMBAGI_SERATUS)));
        } else if (cekData(dataUang, CONST_999, CONST_1999)) {
            result.append(CONST_SPASI).append("Seribu").append(getTerbilang(dataUang.subtract(new BigDecimal(PEMBAGI_SERIBU))));
        } else if (cekData(dataUang, CONST_1999, CONST_999_RIBU)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SERIBU))).append(CONST_SPASI).append("Ribu").append(getTerbilang(mod(dataUang, PEMBAGI_SERIBU)));
        } else if (cekData(dataUang, CONST_999_RIBU, CONST_999_JUTA)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SEJUTA))).append(CONST_SPASI).append("Juta").append(getTerbilang(mod(dataUang, PEMBAGI_SEJUTA)));
        } else if (cekData(dataUang, CONST_999_JUTA, CONST_999_MILYAR)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SEMILYAR))).append(CONST_SPASI).append("Milyar").append(getTerbilang(mod(dataUang, PEMBAGI_SEMILYAR)));
        } else if (cekData(dataUang, CONST_999_MILYAR, CONST_999_TRILYUN)) {
            result.append(getTerbilang(div(dataUang, PEMBAGI_SETRILYUN))).append(CONST_SPASI).append("Trilyun").append(getTerbilang(mod(dataUang, PEMBAGI_SETRILYUN)));
        }

        return result.toString();
    }

    // ambil terbilang untuk satuan
    private String getSatuan(int data) {
        switch (data) {
            case 1:
                return "Satu";
            case 2:
                return "Dua";
            case 3:
                return "Tiga";
            case 4:
                return "Empat";
            case 5:
                return "Lima";
            case 6:
                return "Enam";
            case 7:
                return "Tujuh";
            case 8:
                return "Delapan";
            case 9:
                return "Sembilan";
            case 10:
                return "Sepuluh";
            case 11:
                return "Sebelas";
            default:
                return " ";
        }
    }

    // cek apakah data memenuhi syarat
    private boolean cekData(BigDecimal dataPembanding, String strBatasBawah, String strBatasAtas) {
        BigDecimal batasBawah = new BigDecimal(strBatasBawah);
        BigDecimal batasAtas = new BigDecimal(strBatasAtas);
        if (dataPembanding.compareTo(batasBawah) > 0) {
            if (dataPembanding.compareTo(batasAtas) <= 0) {
                return true;
            }
        }
        return false;
    }

    // mengambil sisa hasil bagi
    private BigDecimal mod(BigDecimal data, String strPembagi) {
        BigDecimal pembagi = new BigDecimal(strPembagi);
        return data.remainder(pembagi);
    }

    // mengambil hasil bagi dengan membuang angka dibelakang koma
    private BigDecimal div(BigDecimal data, String strPembagi) {
        BigDecimal pembagi = new BigDecimal(strPembagi);
        return data.divide(pembagi, 1);
    }

    public static String nominal(BigDecimal txtAngka) {
        String angka = "";
        if (txtAngka != null) {
            angka = new StringUtil().getTerbilang(txtAngka) + " Rupiah";
        }
        return angka;
    }
    //end of converter decimal to nominal
    
    private boolean IN(String str, String strArrMerge) {
        StringTokenizer token = new StringTokenizer(strArrMerge, ",");
        List<String> list = new ArrayList<String>();
        while (token.hasMoreTokens()) {
            list.add(token.nextToken());
        }
        return in(str, list);
    }

    public boolean in(String str, List<String> list) {
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

    public boolean in(String str, String[] strArr) {
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
