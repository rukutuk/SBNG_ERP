/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constant.UIConstants;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author charisma
 */
public class DateUtil {

    public static Date convertStringToDate(final String date,
            final String dateFormat) {
        if (date == null) {
            return null;
        }

        final String dateTrim = date.trim();
        if (dateTrim.length() == 0) {
            return null;
        }
        final SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Date result = null;
        try {
            result = df.parse(dateTrim);
            Calendar cal = Calendar.getInstance();
            cal.setTime(result);
            int year = cal.get(Calendar.YEAR);
            if (year < 100) {
                cal.add(Calendar.YEAR, 2000);
            }
            result = cal.getTime();
        } catch (ParseException x) {
        }
        return result;
    }

    public static Date stdDateLiteralToDate(String ds) {
        if (ds == null) {
            return null;
        }

        String dsTrim = ds.trim();
        if (dsTrim.length() == 0) {
            return null;
        }

        Date d = null;
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

        try {
            d = fmtDate.parse(dsTrim);
        } catch (ParseException e) {
            System.out.println("Warning: StdDate: Invalid Date Format: [" + ds
                    + "]");
        }

        return d;
    }

    public static Date stdStampLiteralToDate(String ds) {
        if (ds == null) {
            return null;
        }

        String dsTrim = ds.trim();
        if (dsTrim.length() == 0) {
            return null;
        }

        Date d = null;
        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            d = fmtDate.parse(dsTrim);
        } catch (ParseException e) {
            System.out.println("Warning: StdStamp: Invalid Date Format: [" + ds
                    + "]");

        }

        return d;

    }

    public static String dateToStdDateLiteral(Date d) {
        if (d == null) {
            return "null";
        }

        SimpleDateFormat fmtDate = new SimpleDateFormat(UIConstants.DateFormat.STD_DATE_LITERAL);

        return fmtDate.format(d);

    }

    public static String dateToStdStampLiteral(Date d) {
        if (d == null) {
            return "null";
        }

        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return fmtDate.format(d);

    }

    public static String dateToStdCustomLiteral(Date d, String customFormat) {
        if (d == null) {
            return "null";
        }

        SimpleDateFormat fmtDate = new SimpleDateFormat(customFormat);

        return fmtDate.format(d);

    }

    public static void printStampLiteral(Date d) {

        SimpleDateFormat fmtDate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println(fmtDate.format(d));

    }

    public static Date hourMinuteTimeLiteralToDate(String ds) {
        if (ds == null) {
            return null;
        }

        String dsTrim = ds.trim();
        if (dsTrim.length() == 0) {
            return null;
        }

        Date d = null;
        SimpleDateFormat fmtDate = new SimpleDateFormat("HH:mm");

        try {
            d = fmtDate.parse(dsTrim);
        } catch (ParseException e) {
            System.out.println("Warning: Parse: Invalid Time Format: [" + ds
                    + "]");

        }

        return d;

    }

    public static Date getNowHourMinuteOnly() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();

    }

    public static String getCurrentMonth() {
        Format f = new SimpleDateFormat("MM");
        return f.format(new Date());
    }

    public static String getCurrentYear() {
        Format f = new SimpleDateFormat("yy");
        return f.format(new Date());
    }

    public static String getCurrentMonthYear() {
        Format f = new SimpleDateFormat("MM/yy");
        return f.format(new Date());
    }

    public static String getStdDateTime(Date d) {
        Format f = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        String result = f.format(d) + " WIB";
        return result;
    }

    public static String getStdDateTimeDisplay(Date d) {
        String result = "-";

        if (d != null) {
            Format f = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
            result = f.format(d) + " WIB";
        }

        return result;
    }

    public static String getStdDateTimeDisplayBC(Date d) {
        String result = "-";
        if (d != null) {
            Format f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            result = f.format(d);
        }
        return result;
    }

    public static String getStdDateDisplay(Date d) {
        String result = "-";

        if (d != null) {
            Format f = new SimpleDateFormat("dd MMM yyyy");
            // result = f.format(d)+" WIB";
            result = f.format(d);
        }

        return result;
    }

    public static String getStdDateIndOnly(Date d) {
        Format f = new SimpleDateFormat("dd-MMM-yyyy");
        String result = f.format(d);
        return result;
    }

    public static Date getDateAdd(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    public static Date getTodayPlus(final int nDays) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, nDays);

        final Date theDay = cal.getTime();
        return theDay;
    }

    public static String getTodayPlusAsConstraint(final int nDays) {
        return new SimpleDateFormat("yyyyMMdd").format(getTodayPlus(nDays));
    }

    public static Date normalizeToDateOnly(Date d) {
        Calendar nd = Calendar.getInstance();

        nd.setTime(d);
        nd.set(Calendar.HOUR_OF_DAY, 0);
        nd.set(Calendar.MINUTE, 0);
        nd.set(Calendar.SECOND, 0);
        nd.set(Calendar.MILLISECOND, 0);

        return nd.getTime();

    }

    public static Boolean isEqualsDateOnly(Date d1, Date d2) {
        Boolean res = false;
        if (d1 == null && d2 == null) {
            res = true;
        } else if (d1 == null || d2 == null) {
            res = false;
        } else {
            Date dOne = DateUtil.normalizeToDateOnly(d1);
            Date dTwo = DateUtil.normalizeToDateOnly(d2);
            if (dOne.compareTo(dTwo) == 0) {
                res = true;
            }
        }
        return res;
    }

    // Date dMin = minimal date, Date d2 parameter
    // is second parameter >= first parameter
    public static Boolean isGreaterThanOrEqualsDateOnly(Date dMin, Date dPar) {
        Boolean res = false;
        if (dMin == null && dPar == null) {
            res = true;
        } else if (dMin == null || dPar == null) {
            res = false;
        } else {
            Date dOne = DateUtil.normalizeToDateOnly(dMin);
            Date dTwo = DateUtil.normalizeToDateOnly(dPar);
            if (dTwo.compareTo(dOne) == 0 || dTwo.after(dOne)) {
                res = true;
            }
        }
        return res;
    }

    public static boolean compareDate(Date date1, String comparator, Date date2) {
        Boolean res = false;
        if (date1 == null && date2 == null) {
            res = true;
        } else if (date1 == null || date2 == null) {
            res = false;
        } else {
            Date dOne = DateUtil.normalizeToDateOnly(date1);
            Date dTwo = DateUtil.normalizeToDateOnly(date2);
            int a = dOne.compareTo(dTwo);
            if (comparator.equalsIgnoreCase(UIConstants.Compares.MORE_THAN)) {
                if (a > 0) {
                    res = true;
                }
            } else if (comparator.equalsIgnoreCase(UIConstants.Compares.MORE_THAN_EQUAL)) {
                if (a > 0 || a == 0) {
                    res = true;
                }
            } else if (comparator.equalsIgnoreCase(UIConstants.Compares.LESS_THAN)) {
                if (a < 0) {
                    res = true;
                }
            } else if (comparator.equalsIgnoreCase(UIConstants.Compares.LESS_THAN_EQUAL)) {
                if (a < 0 || a == 0) {
                    res = true;
                }
            } else if (comparator.equalsIgnoreCase(UIConstants.Compares.EQUAL)) {
                if (a == 0) {
                    res = true;
                }
            }
        }
        return res;
    }

    // Date d1 = dMax, Date dParam date parameter
    /*
     * @Edit wira 09-May-12
     * deskripsi fungsi = is 2nd parameter is <= 1st parameter
     * (disamakan dengan fungsi perbandingan tanggal lainnya)
     * Ubah dari dOne.before(dTwo) menjadi dTwo.before(dOne)
     */
    public static Boolean isLessThanOrEqualsDateOnly(Date dMax, Date dParam) {
        Boolean res = false;
        if (dMax == null && dParam == null) {
            res = true;
        } else if (dMax == null || dParam == null) {
            res = false;
        } else {
            Date dOne = DateUtil.normalizeToDateOnly(dMax);
            Date dTwo = DateUtil.normalizeToDateOnly(dParam);
            if (dTwo.compareTo(dOne) == 0 || dTwo.before(dOne)) {
                res = true;
            }
        }
        return res;
    }

    // Date minDate = minimal date, Date maxDate = maximal date, Date dParam
    // date date parameter
    public static Boolean isInRangeDateOnly(Date minDate, Date maxDate,
            Date dParam) {
        Boolean res = false;
        if (minDate == null || maxDate == null || dParam == null) {
            res = false;
        } else {
            Date dMin = DateUtil.normalizeToDateOnly(minDate);
            Date dMax = DateUtil.normalizeToDateOnly(maxDate);
            Date dPar = DateUtil.normalizeToDateOnly(dParam);
            if ((dPar.after(dMin) && dPar.before(dMax))
                    || dPar.compareTo(dMin) == 0 || dPar.compareTo(dMax) == 0) {

                res = true;
            }
        }
        return res;
    }

    public static boolean isDateLessThanDaysFrom(Date start, Date d,
            Integer days) {
        Calendar cExpected = Calendar.getInstance();
        cExpected.setTime(start);
        cExpected.add(Calendar.DATE, -days);

        return cExpected.getTime().compareTo(d) <= 0 && d.compareTo(start) < 0;
    }

    public static Boolean isBetween(Date when, Date start, Date end) {

        return start.compareTo(when) <= 0 && when.compareTo(end) <= 0;
    }

    // is Second Parameter isGreaterThan First Parameter
    public static boolean isGreaterThanDateOnly(Date lesser, Date greater) {
        boolean result = false;
        if (lesser == null && greater == null) {
            result = true;
        } else if (lesser == null || greater == null) {
            result = false;
        } else {
            lesser = DateUtil.normalizeToDateOnly(lesser);
            greater = DateUtil.normalizeToDateOnly(greater);
            if (greater.after(lesser)) {
                result = true;
            }
        }
        return result;
    }

    // is Second Parameter isGreaterThan First Parameter
    public static boolean isLesserThanDateOnly(Date greater, Date lesser) {
        boolean result = false;
        if (lesser == null && greater == null) {
            result = true;
        } else if (lesser == null || greater == null) {
            result = false;
        } else {
            lesser = DateUtil.normalizeToDateOnly(lesser);
            greater = DateUtil.normalizeToDateOnly(greater);
            if (lesser.before(greater)) {
                result = true;
            }
        }
        return result;
    }

    public static int compareDDDMMOnly(Date one, Date two) {
        Calendar calOne = Calendar.getInstance();
        Calendar calTwo = Calendar.getInstance();
        calOne.setTime(one);
        calTwo.setTime(two);
        if (calOne.get(Calendar.MONTH) > calTwo.get(Calendar.MONTH)) {
            return 1;
        } else if (calOne.get(Calendar.MONTH) < calTwo.get(Calendar.MONTH)) {
            return -1;
        }
        if (calOne.get(Calendar.DAY_OF_MONTH) > calTwo.get(Calendar.DAY_OF_MONTH)) {
            return 1;
        } else if (calOne.get(Calendar.DAY_OF_MONTH) < calTwo.get(Calendar.DAY_OF_MONTH)) {
            return -1;
        }
        return 0;
    }

    public static Date getTglBC11Plus(final int nDays, final Date tglBC) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tglBC);
        cal.add(Calendar.DATE, nDays);

        int date = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        //System.out.println("cal = " + date + " - " + month + " - " + year);
        return cal.getTime();
    }

    public static Date addDate(final int amt, int dateComp, final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dateInit = cal.get(Calendar.DATE);
        int monthInit = cal.get(Calendar.MONTH);
        int yearInit = cal.get(Calendar.YEAR);
        int hourInit = cal.get(Calendar.HOUR);
        int minInit = cal.get(Calendar.MINUTE);
        int secInit = cal.get(Calendar.SECOND);
//        System.out.println("cal = " + dateInit + " - " + monthInit + " - " + yearInit + " = " + hourInit + " - " + minInit + " - " + secInit);
        if (dateComp == Calendar.DATE) {
            cal.add(Calendar.DATE, amt);
        } else if (dateComp == Calendar.MONTH) {
            cal.add(Calendar.MONTH, amt);
        } else if (dateComp == Calendar.YEAR) {
            cal.add(Calendar.YEAR, amt);
        } else if (dateComp == Calendar.MINUTE) {
            cal.add(Calendar.MINUTE, amt);
        } else if (dateComp == Calendar.HOUR) {
            cal.add(Calendar.HOUR, amt);
        } else if (dateComp == Calendar.SECOND) {
            cal.add(Calendar.SECOND, amt);
        }

        int dateAfter = cal.get(Calendar.DATE);
        int monthAfter = cal.get(Calendar.MONTH);
        int yearAfter = cal.get(Calendar.YEAR);
        int hourAfter = cal.get(Calendar.HOUR);
        int minAfter = cal.get(Calendar.MINUTE);
        int secAfter = cal.get(Calendar.SECOND);
//        System.out.println("cal = " + dateAfter + " - " + monthAfter + " - " + yearAfter + " = " + hourAfter + " - " + minAfter + " - " + secAfter);
        return cal.getTime();
    }

    /*
     * Service :
     * guys.. u can use it as well
     * wether the first date is interface second or first
     */
    public static int getDiffDayBetween2Date(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);
        int diffDay = 0;

        if (c1.before(c2)) {
            diffDay = countDiffDay(c1, c2);
        } else {
            diffDay = countDiffDay(c2, c1);
        }

        return diffDay;
    }

    public static int countDiffDay(Calendar c1, Calendar c2) {
        int returnInt = 0;
        while (!c1.after(c2)) {
            c1.add(Calendar.DAY_OF_MONTH, 1);
            returnInt++;
        }

        if (returnInt > 0) {
            returnInt = returnInt - 1;
        }

        return (returnInt);
    }

    public static Date setToMidNite(Date d) {
        Calendar nd = Calendar.getInstance();
        System.out.println("d = " + d);
        nd.setTime(d);
        nd.set(Calendar.HOUR_OF_DAY, nd.getMaximum(Calendar.HOUR_OF_DAY));
        nd.set(Calendar.MINUTE, nd.getMaximum(Calendar.MINUTE));
        nd.set(Calendar.SECOND, nd.getMaximum(Calendar.SECOND));
        nd.set(Calendar.MILLISECOND, nd.getMaximum(Calendar.MILLISECOND));


        Date d2 = nd.getTime();
        System.out.println("d2 = " + d2);
        return nd.getTime();

    }

    public static void main(String[] args) {
//        getTglBC11Plus(60, new Date());
//        String a = getDDMMYY_HH24MMSS(new Date());
        /*Date date1 = new Date();
        date1 = addDate(1, Calendar.DATE, date1);
        Date date2 = new Date();
        System.out.println("date2 = " + date2);
        System.out.println("date1 = " + date1);
        boolean bool = isGreaterThanOrEqualsDateOnly(date2, date1);
        System.out.println("a = " + bool);

//        System.out.println("hasil = "+DateUtil.);
//        System.out.println("hasil = "+DateUtil.addDate(-9999, Calendar.DATE, new Date()));

        Date date = convertStringToDate("28-03-2012", "dd-MM-yyyy");
        Date date3 = convertStringToDate("29-03-2012", "dd-MM-yyyy");
        Long longDate = date.getTime();
        Long longDate2 = date3.getTime();
        Long nilai = longDate2 - longDate;
        Date convertDate = new Date(nilai);
        System.out.println("convertDate = " + convertDate);
        System.out.println("date = " + dateToStdCustomLiteral(date, UIConstants.DateFormat.DD_MM_YYYY));
*/
        Date date1 = new Date();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date date2 = new Date();
        printDiffDate(getDiffDate(date1, date2));
        
    }

    public static int getJam12(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR);
    }

    public static int getJam24(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static String getDDMMYY_HH24MMSS(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);

        month++;
        String tanggal = StringUtil.leftPad(String.valueOf(date), 2, "0");
        String bulan = StringUtil.leftPad(String.valueOf(month), 2, "0");
        String jam = StringUtil.leftPad(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)), 2, "0");
        String menit = StringUtil.leftPad(String.valueOf(cal.get(Calendar.MINUTE)), 2, "0");
        String detik = StringUtil.leftPad(String.valueOf(cal.get(Calendar.SECOND)), 2, "0");
        StringBuffer buff = new StringBuffer().append(cal.get(Calendar.DATE)).
                append("-").append(StringUtil.leftPad(String.valueOf(month), 2, "0")).
                append("-").append(cal.get(Calendar.YEAR)).
                append(" ").append(jam).append(":").append(menit).
                append(":").append(detik);

        return buff.toString();
    }

    /**
     * 
     */
    public static int compareDate(Date date1, Date date2) {
        int compareDate = 0;
        if (date1 != null && date2 != null) {
            long date1L = date1.getTime();
            long date2L = date2.getTime();

            if (date1L > date2L) {
                compareDate = 1;
            } else if (date1L > date2L) {
                compareDate = -1;
            }
        }
        return compareDate;
    }

    public static int getMenit(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    public static int getDetik(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.SECOND);
    }

    public static int getBulan(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    public static int getTahun(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static int getHariOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHariOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static Date getNowAsDateOnly() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();

    }
    public static Date convertTanggalSiap(String tgl) {
        Date d = null;
        try {
            if (tgl != null) {
                if (tgl.trim().length() == 12) {
                    d = DateUtil.convertStringToDate(tgl, "yyyyMMddkkmm");
                } else if (tgl.trim().length() == 14) {
                    d = DateUtil.convertStringToDate(tgl, "yyyyMMddkkmmss");
                }
            }
        } catch (Exception ex) {
        }
        return d;
    }
    /**
     * Needed to create XMLGregorianCalendar instances
     */
    private static DatatypeFactory df = null;

    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                    "Exception while obtaining DatatypeFactory instance", dce);
        }
    }

    /**
     * Converts a java.util.Date into an instance of XMLGregorianCalendar
     *
     * @param date Instance of java.util.Date or a null reference
     * @return XMLGregorianCalendar instance whose value is based upon the
     *  value in the date parameter. If the date parameter is null then
     *  this method will simply return null.
     */
    public static XMLGregorianCalendar dateToGregorian(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        }
    }

    /**
     * Converts an XMLGregorianCalendar to an instance of java.util.Date
     *
     * @param xgc Instance of XMLGregorianCalendar or a null reference
     * @return java.util.Date instance whose value is based upon the
     *  value in the xgc parameter. If the xgc parameter is null then
     *  this method will simply return null.
     */
    public static java.util.Date gregorianToDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public static long getDiffDate(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        return diff;
    }
//    public static String printDiffDate(Date date1, Date date2) {
    public static String printDiffDateSecond(long diff) {
        return (diff / 1000) + " seconds, ";
    }
    public static String printDiffDate(long diff) {
//        Calendar calendar1 = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//        calendar1.setTime(date1);
//        calendar2.setTime(date2);
//        long milliseconds1 = calendar1.getTimeInMillis();
//        long milliseconds2 = calendar2.getTimeInMillis();
//        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);
        /*System.out.println("\nThe Date Different Example");
        System.out.println("Time in milliseconds: " + diff
                + " milliseconds.");
        System.out.println("Time in seconds: " + diffSeconds
                + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes
                + " minutes.");
        System.out.println("Time in hours: " + diffHours
                + " hours.");
        System.out.println("Time in days: " + diffDays
                + " days.");*/
        String diffDate = diffDays + " Days, " + diffHours + ":" + diffMinutes + ":" + diffSeconds;
//        System.out.println("diffDate = " + diffDate);
        return diffDate;
    }
}
