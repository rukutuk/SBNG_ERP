/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package constant;

/**
 *
 * @author Tata
 */
public class UIConstants {



    public class DataType {

        public static final String DATE = "DATE";
        public static final String STRING = "STRING";
    }



    public class Compares {

        public static final String EQUAL = "=";
        public static final String MORE_THAN = ">";
        public static final String MORE_THAN_EQUAL = ">=";
        public static final String LESS_THAN = "<";
        public static final String LESS_THAN_EQUAL = "<=";
    }

    public class DateFormat {

        public static final String yyyyMMdd = "yyyyMMdd";
        public static final String ddMMyyyyhhmmss = "ddMMyyyyhhmmss";
        public static final String STD_DATE_LITERAL = "yyyy-MM-dd";
        public static final String DD_MM_YYYY = "dd-MM-yyyy";
        public static final String DD_MMM_YYYY = "dd-MMM-yyyy";
        public static final String DDMMYY = "ddMMyy";
        public static final String YYYYMMDD = "yyyyMMdd";
        public static final String HH_MM = "hh:mm";
        public static final String HH_MM_SS = "hh:mm:ss";
        public static final String HHMMSS = "hhmmss";
        public static final String DD_MM_YYYY__HH_MM = "dd-MM-yyyy hh:mm";
        public static final String DD_MM_YYYY__HH_MM_SS = "dd-MM-yyyy hh:mm:ss";
        public static final String DD_MM_YYYY___HH_MM_SS = "dd-MM-yyyy_hh-mm-ss";
        public static final String DD_MM_YYYY__KK_MM_SS = "dd-MM-yyyy kk:mm:ss";
        public static final String DD_MM_YYYY__HH24_MM_SS = "dd-MM-yyyy HH:mm:ss";
        public static final String DDMMYYYY__KK_MM_SS = "ddMMyyyy kkmmss";
        public static final String YYYYMMDDHH24MISS = "yyyyMMddHHmmss";
        /*Oracle Date format*/
        public static final String HH_MI_SS = "hh:mi:ss";
        public static final String DD_MM_YYYY__HH_MI = "dd-MM-yyyy hh:mi";
        public static final String DD_MM_YYYY__HH_MI_SS = "dd-MM-yyyy hh:mi:ss";
        public static final String DD_MM_YYYY__HH24_MI = "dd-MM-yyyy hh24:mi";
        public static final String DD_MM_YYYY__HH24_MI_SS = "dd-MM-yyyy hh24:mi:ss";
    }

    public class Format {

        public static final String DECIMAL = "#0,000.##";
        public static final String CURRENCY = "##,###.####";
    }


    public class Key {

        public static final int KEY_MAX_RESULTS = 10;
        public static final String KEY_CREDENTIAL_VO = "CREDENTIAL_VO";
    }

    public class Zul {

        public static final String POPUP_LOOKUP_NM_EKS = "/ekspor/lookup/LookupNmEks.zul";
        public static final String POPUP_LOOKUP_NM_EKS_THREE_FORM = "/ekspor/lookup/LookupNmEksThreeForm.zul";
        public static final String POPUP_LOOKUP_NM_PPJK = "/ekspor/lookup/LookupNmPpjk.zul";
        public static final String POPUP_LOOKUP_URAIAN_RESPON = "/ekspor/lookup/BrowseResponDaftarUraianReject.zul";
        public static final String POPUP_MESSAGE_PROSES = "/ekspor/msg/MessageProses.zul";
    }

    public class ReportConnection {

        public static final String URL = "jdbc:oracle:thin:@10.0.4.53:1521:DEVIDM";
        public static final String NAME = "oracle.jdbc.OracleDriver";
        public static final String CONN_USER = "ekspor";
        public static final String CONN_PSWD = "ekspor";
    }
}
