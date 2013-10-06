/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constant.UIConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import oracle.sql.CLOB;

/**
 *
 */
public class FormatUtil {



    public static String formatDecimal(double money) {
        NumberFormat formatter = new DecimalFormat(UIConstants.Format.DECIMAL);
        return formatter.format(money);
    }

    public static String formatDecimal(double money, String format) {
        NumberFormat formatter = new DecimalFormat(format);
        return formatter.format(money);
    }

    public static String formatRupiah(double money) {
        NumberFormat num = NumberFormat.getInstance();
        Currency currency = Currency.getInstance("IDR");
        //System.out.println("IDR");    
        num.setCurrency(currency);
        return num.format(money);
    }

    public static String fRptoDouble(String money) {
        if (money.equalsIgnoreCase("")) {
            money = "0";
        }
        //System.out.println("DOUBLE");
        NumberFormat nf = NumberFormat.getInstance();
        Number number = null;
        Currency currency = Currency.getInstance("IDR");
        nf.setCurrency(currency);
        try {
            number = nf.parse(money);
        } catch (Exception e) {
            number = 0;
        }
        money = VUtil.nvl(number.toString(), "0");
        return money;
    }

    public static String formatRupiah(Object obj) {
        String retVal = null;
        if (obj instanceof Number) {
            Currency currency = Currency.getInstance("IDR");
            NumberFormat num = NumberFormat.getInstance();
            num.setCurrency(currency);
            retVal = num.format(obj);
        }
        return retVal;
    }

    public static String formatRupiah(BigDecimal money) {
        if (money != null) {
            NumberFormat num = NumberFormat.getInstance();
            num.setMaximumFractionDigits(4);
            System.out.println("--" + num.format(money.doubleValue()));
            return num.format(money.doubleValue());
        } else {
            return "0";
        }
    }

    public static String formatString(String string, String mask)
            throws java.text.ParseException {
        MaskFormatter mf =
                new javax.swing.text.MaskFormatter(mask);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(string);
    }

    public static boolean formatDataTypeToBoolean(Object o) {
        Boolean buff = null;
        if (o == null) {
            buff = null;
        }
        if (o instanceof String) {
            if (String.valueOf(o).equalsIgnoreCase("true") || String.valueOf(o).equalsIgnoreCase("t")) {
                buff = true;
            } else if (String.valueOf(o).equalsIgnoreCase("false") || String.valueOf(o).equalsIgnoreCase("f")) {
                buff = false;
            }
        } else {
            if (String.valueOf(o).equalsIgnoreCase("1")) {
                buff = true;
            } else if (String.valueOf(o).equalsIgnoreCase("0")) {
                buff = false;
            }
        }
        return buff;
    }

    static public BigInteger formatDataTypeToBigInteger(Object obj) {
        BigInteger buff = null;
        if (obj == null) {
            buff = null;
        } else if (obj instanceof BigInteger) {
            buff = (BigInteger) obj;
        } else if (obj instanceof Integer) {
            buff = new BigInteger(((Integer) obj).toString());
        } else if (obj instanceof BigDecimal) {
            buff = new BigInteger(String.valueOf(obj));
        } else if (obj instanceof String) {
            buff = EmptyStringBigInteger(String.valueOf(obj));
        } else {
            buff = (BigInteger) obj;
        }
        return buff;
    }

    static public BigDecimal formatDataTypeToBigDecimal(Object obj) {

        BigDecimal buff = null;
        if (obj == null) {
            buff = null;
        } else if (obj instanceof Integer) {
            buff = new BigDecimal(((Integer) obj).toString());
        } else if (obj instanceof Long) {
            buff = new BigDecimal(((Long) obj).toString());
        } else if (obj instanceof Double) {
            buff = new BigDecimal(((Double) obj).toString());
        } else if (obj instanceof BigDecimal) {
            buff = (BigDecimal) obj;
        } else if (obj instanceof BigInteger) {
            buff = new BigDecimal((BigInteger) obj);
        } else if (obj instanceof String) {
            buff = EmptyStringBigDecimal(String.valueOf(obj));
        } else {
            buff = (BigDecimal) obj;
        }
        return buff;
    }

    static public Integer formatDataTypeToInteger(Object o) {
        Integer buff = null;
        if (o == null) {
            buff = null;
        } else if (o instanceof BigDecimal) {
            buff = ((BigDecimal) o).intValue();
        } else if (o instanceof Character) {
            buff = new Integer(String.valueOf(o));
        } else if (o instanceof BigInteger) {
            buff = ((BigInteger) o).intValue();
        } else if (o instanceof String) {
            buff = EmptyStringInteger(String.valueOf(o));
        } else if (o instanceof Integer) {
            buff = (Integer) o;
        } else {
            buff = (Integer) o;
        }
        return buff;
    }

    static public String formatDataTypeToString(Object obj) {
        String buff = "";
        if (obj == null) {
            buff = null;
        }
        if (obj instanceof BigDecimal) {
            buff = String.valueOf(((BigDecimal) obj));
        } else if (obj instanceof Integer) {
            buff = String.valueOf(((Integer) obj));
        } else if (obj instanceof String) {
            buff = String.valueOf(obj);
        } else if (obj instanceof BigInteger) {
            buff = String.valueOf(((BigInteger) obj));
        } else if (obj instanceof String) {
            buff = String.valueOf(obj);
        } else if (obj instanceof Date) {
            buff = DateUtil.getStdDateTime((Date) obj);
        } else if (obj instanceof CLOB) {
            BufferedReader bufferRead = null;
            try {
                oracle.sql.CLOB clb = (oracle.sql.CLOB) obj;
                if (clb == null) {
                    return "";
                }
                StringBuffer str = new StringBuffer();
                String strng;
                bufferRead = new BufferedReader(clb.getCharacterStream());
                while ((strng = bufferRead.readLine()) != null) {
                    str.append(strng);
                }
                return str.toString();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (bufferRead != null) {
                        bufferRead.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
//            buff = (String) obj;
            return (String) obj;
        }

        return buff;
    }

    static public Date formatDataTypeToDate(Object obj) {
        Date buff = null;
        if (obj instanceof Date) {
            buff = (Date) obj;
        } else if (obj instanceof String) {
            buff = DateUtil.stdDateLiteralToDate((String) obj);
        }
        return buff;
    }

    public static void main(String[] args) {
        formatRupiah(new BigDecimal(204.12345));
        //System.out.println("formatCar = " + formatNPWP("5", "123456789123456"));
        //System.out.println(new BigDecimal("1000").divide(new BigDecimal("76.923")));
        // System.out.println(new BigDecimal("2.5"), RoundingMode.HALF_EVEN);
        //BigDecimal a;
        //a = BigDecimal.ZERO;
//        System.out.println(new BigDecimal("0").divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN));
//        System.out.println("" + formatNPWP("0", "0129389107230009877"));
//        System.out.println("" + formatRupiah(new BigDecimal("115").divide(new BigDecimal("500"))));
//        System.out.println("" + new BigDecimal("115").divide(new BigDecimal("500")));
//        System.out.println("" + new BigDecimal("0.23").multiply(new BigDecimal("300")));
//        System.out.println("" + fRptoDouble("0,1293"));
//        BigDecimal vcif = new BigDecimal(FormatUtil.fRptoDouble(VUtil.nvl("300", "0"))).multiply(new BigDecimal(FormatUtil.fRptoDouble(VUtil.nvl("0.23", "0"))));
//        System.out.println(FormatUtil.formatRupiah(vcif));
    }

    public static BigDecimal EmptyStringBigDecimal(String txtAngka) {
        BigDecimal hasil = null;
        if (!txtAngka.equalsIgnoreCase("")) {
            hasil = new BigDecimal(txtAngka.trim());
        }
        return hasil;
    }

    public static Integer EmptyStringInteger(String txtAngka) {
        Integer hasil = null;
        if (!txtAngka.equalsIgnoreCase("")) {
            hasil = new Integer(txtAngka);
        }
        return hasil;
    }

    public static BigInteger EmptyStringBigInteger(String txtAngka) {
        BigInteger hasil = null;
        if (!txtAngka.equalsIgnoreCase("")) {
            hasil = new BigInteger(txtAngka);
        }
        return hasil;
    }
}
