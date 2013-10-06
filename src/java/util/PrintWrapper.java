/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class PrintWrapper {

    static Logger logger = Logger.getLogger(PrintWrapper.class.getName());
    private static PrintWrapper printWrapper = null;

    public static PrintWrapper getInstance() {
        if (printWrapper == null) {
            printWrapper = new PrintWrapper();
        }
        return printWrapper;
    }
    public static String print(String strToPrint, Logger logger) {
        logger.info(strToPrint);
        return strToPrint;
    }

    public static String print(String strToPrint) {
        logger.info(strToPrint);
        return strToPrint;
    }

    public static String printSql(String sql) {
        return print("sql ***> " + sql);
    }

    public static String printSql(String sql, Logger logger) {
        return print("sql ***> " + sql, logger);
    }

    public static String printBegin(String methodName) {
        return print("Begin <<<<<<<<<<<<<<<<<<< " + methodName + "()");
    }

    public static String printBeginBanget(String methodName) {
        return print("\n\n\n\n\nBegin <<<<<<<<<<<<<<<<<<< " + methodName + "()");
    }

    public static String printEnd(String methodName) {
        return print("End >>>>>>>>>>>>>>>>>>> " + methodName + "()");
    }

    public static String printEndBanget(String methodName) {
        return print("End >>>>>>>>>>>>>>>>>>> " + methodName + "()\n\n\n\n\n");
    }

    public static String printBegin(String methodName, Logger logger) {
        return print("Begin <<<<<<<<<<<<<<<<<<< " + methodName + "()", logger);
    }

    public static String printEnd(String methodName, Logger logger) {
        return print("End >>>>>>>>>>>>>>>>>>> " + methodName + "()", logger);
    }

    public static String printList(List listname) {
        return print("List ***> " + listname);
    }

    public static String printListSize(int listSize) {
        return print("List Size ***> " + listSize);
    }

    public static String printListSize(List listSize) {
        int size = 0;
        if (listSize != null && listSize.size() > 0) {
            size = listSize.size();
        }
        return print("List Size ***> " + size);
    }

    public static String printSingleResultString(String StringName) {
        return print("String out ***> " + StringName);
    }

    public static String printSingleResultBigDecimal(BigDecimal BigDecimalName) {
        return print("String out ***> " + BigDecimalName);
    }

    /*
     * Print variable
     * Use:
     * PrintWrapper.printVar("var1", var1, "var2", var2);
     * got result:
     * "Param -> var1 = [value1], var2 = [value2],
     */
    public static String printVar(Object... obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("%Param ------> ");
        int i = 0;
        for (Object o : obj) {
            if (++i % 2 != 0) {
                if (o != null) {
                    sb.append(o).append(" = ");
                } else {
                    sb.append("null");
                }
            } else {
                if (o != null) {
                    sb.append(o).append(", ");
                } else {
                    sb.append("null, ");
                }
            }
        }
        logger.info(sb);
        return sb.toString();
    }

    /*
     * Print variable
     * Use:
     * PrintWrapper.printVar("var1", var1, "var2", var2);
     * got result:
     * "Param -> var1 = [value1], var2 = [value2],
     */
    public static String printVarPass(Object... obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("%Param PASSING ------> ");
        int i = 0;
        for (Object o : obj) {
            if (++i % 2 != 0) {
                if (o != null) {
                    sb.append(o).append(" = ");
                } else {
                    sb.append("null");
                }
            } else {
                if (o != null) {
                    sb.append(o).append(", ");
                } else {
                    sb.append("null, ");
                }
            }
        }
//        logger.info(sb);
        logger.info(sb);
        return sb.toString();
    }

    public static String safeException(Exception e, String addInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(print("--INFO: SAFE EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: SAFE EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: " + addInfo + "\n"));
        sb.append(print("-----MESSAGE: " + e.getMessage() + "\n"));
        e.printStackTrace();
        sb.append(print("--INFO: SAFE EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: SAFE EXCEPTION ##########################################################################################\n"));
        return sb.toString();
    }

    public static String errorException(Exception e, String addInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(print("--INFO: ERROR EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: ERROR EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: " + addInfo + "\n"));
        sb.append(print("-----MESSAGE: " + e.getMessage() + "\n"));
        e.printStackTrace();
        sb.append(print("--INFO: ERROR EXCEPTION ##########################################################################################\n"));
        sb.append(print("--INFO: ERROR EXCEPTION ##########################################################################################\n"));
        return sb.toString();
    }
}
