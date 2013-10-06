/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import beacukai.ekspor.constant.UIConstants;
import constant.UIConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.East;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.South;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;

/**
 *
 * @author Tata
 */
public class UIUtil {

    public static void popupJasperReport(String jasperFile, Map parameters,
            Collection collection, Window currentWindow, String outputFormat) {
        Window win = new Window("Report", "normal", true);
        win.setWidth("800px");
        win.setHeight("600px");
        win.setParent(currentWindow);

        Iframe report = new Iframe();
        report.setWidth("100%");
        report.setHeight("100%");
        report.setParent(win);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(
                collection);

        Jasperreport jasper = new Jasperreport("");
//        jasper.get


        InputStream is = null;
        AMedia amedia = null;
        InputStream mediais = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            final Execution exec = Executions.getCurrent();
            is = exec.getDesktop().getWebApp().getResourceAsStream(exec.toAbsoluteURI(jasperFile, false));
//            // fill the report
//            JasperPrint jasperPrint = JasperFillManager.fillReport(is,
//                    parameters,
//                    new JREmptyDataSource());

            if (outputFormat.equalsIgnoreCase("pdf")) {
                byte[] buf = null;

                if (collection == null) {
                    buf = JasperRunManager.runReportToPdf(is, parameters,
                            new JREmptyDataSource());
//                    Jasperreport
                } else {
                    buf = JasperRunManager.runReportToPdf(is, parameters,
                            dataSource);
                }

                mediais = new ByteArrayInputStream(buf);
                amedia = new AMedia(null, "pdf", "application/pdf", mediais);
//                amedia = new AMedia("FileFormatExcel", "xls", "application/vnd.ms-excel", mediais);

                System.out.println("amedia = " + amedia);
                System.out.println("currentWindow = " + currentWindow);
            } else if (outputFormat.equalsIgnoreCase("xls")) {
                byte[] buf = null;
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, new JRBeanCollectionDataSource(
                        collection));
                JExcelApiExporter exporterXLS = new JExcelApiExporter();
//                JasperRunManager.
                exporterXLS.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
                exporterXLS.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporterXLS.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporterXLS.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);
                exporterXLS.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporterXLS.exportReport();
                arrayOutputStream.close();
//                mediais = new ByteArrayInputStream(buf);
                mediais = new ByteArrayInputStream(arrayOutputStream.toByteArray());
                amedia = new AMedia("FileFormatExcel", "xls", "application/vnd.ms-excel", mediais);
            } else if (outputFormat.equalsIgnoreCase("csv")) {
                byte[] buf = null;
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, new JRBeanCollectionDataSource(
                        collection));
                JRExporter exporter = new JRCsvExporter();
                if (parameters != null) {
                    exporter.setParameters(parameters);
                }
                exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporter.exportReport();
                arrayOutputStream.close();
//                mediais = new ByteArrayInputStream(buf);
                mediais = new ByteArrayInputStream(arrayOutputStream.toByteArray());
                amedia = new AMedia("report.csv", "csv", "text/csv", mediais);
            } else if (outputFormat.equalsIgnoreCase("txtSave")) {
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, getReportConnection());
                JRTextExporter exporter = new JRTextExporter();
                exporter.setParameter(JRTextExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRTextExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float("5"));
                exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float("11"));
                exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, jasperPrint.getPageWidth());
                exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, jasperPrint.getPageWidth());
                exporter.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT, "\f");
                exporter.exportReport();

                arrayOutputStream.close();

                mediais = new ByteArrayInputStream(arrayOutputStream.toByteArray());
                amedia = new AMedia(jasperPrint.getName() + ".txt", "txt", "text/txt", mediais);
            } else if (outputFormat.equalsIgnoreCase("txtView")) {
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, getReportConnection());
                JRTextExporter exporter = new JRTextExporter();
                exporter.setParameter(JRTextExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRTextExporterParameter.OUTPUT_STREAM, arrayOutputStream);
                exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float("6"));
                exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float("11"));
                exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, jasperPrint.getPageWidth());
                exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, jasperPrint.getPageWidth());
                exporter.setParameter(JRTextExporterParameter.BETWEEN_PAGES_TEXT, "\f");
                exporter.exportReport();

                mediais = new ByteArrayInputStream(arrayOutputStream.toByteArray());
                amedia = new AMedia(jasperPrint.getName(), "txt", "text/txt", mediais);
            }
            report.setContent(amedia);
            win.doModal();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static ListModelList renderListbox(Listbox listbox, List list, ListitemRenderer listItemRender) {
        if (!StringUtil.isListNotEmpty(list)) {
            list = new ArrayList();
        }
        ListModelList model = new ListModelList(list);
        listbox.setModel(new ListModelList(list));
        listbox.setItemRenderer(listItemRender);
        return model;
    }

    public static ListModelList renderListbox(Listbox listbox, List list, ListitemRenderer listItemRender, Paging paging, int recordCount) {
        if (!StringUtil.isListNotEmpty(list)) {
            list = new ArrayList();
        }
        if (recordCount == 0) {
            paging.setVisible(false);
        } else {

            paging.setTotalSize(recordCount);
            paging.setDetailed(true);
            paging.setPageSize(UIConstants.Key.KEY_MAX_RESULTS);
            paging.setVisible(true);
        }


        ListModelList model = new ListModelList(list);
        listbox.setModel(new ListModelList(list));
        listbox.setItemRenderer(listItemRender);
        return model;
    }

    public static void renderCombobox(Combobox combobox, List list, ComboitemRenderer comboItemRender) {
        if (!StringUtil.isListNotEmpty(list)) {
            list = new ArrayList();
        }
        combobox.setModel(new ListModelList(list));
        combobox.setItemRenderer(comboItemRender);
    }

    public static void clearListbox(Listbox listbox) {
        if (listbox != null) {
            ListModelList lml = (ListModelList) listbox.getModel();
            if (lml != null) {
                lml.clear();
            }
        }
    }

    public static void showMenuItem(String url, Div mainInclude, Map map) {
        mainInclude.invalidate();
        mainInclude.getChildren().clear();
        Executions.createComponents(url, mainInclude, map);
        Page page = mainInclude.getPage();
        Div leftInclude = (Div) findDeepComponent(page, "leftInclude");
        West leftPanel = (West) findDeepComponent(page, "leftPanel");
        leftPanel.setOpen(false);
        leftInclude.invalidate();
        leftInclude.getChildren().clear();
        Div rightInclude = (Div) findDeepComponent(page, "rightInclude");
        East rightPanel = (East) findDeepComponent(page, "rightPanel");
        rightPanel.setOpen(false);
        rightInclude.invalidate();
        rightInclude.getChildren().clear();
        Div detailInclude = (Div) findDeepComponent(page, "detailInclude");
        South detailPanel = (South) findDeepComponent(page, "detailPanel");
        detailPanel.setOpen(false);
        detailInclude.invalidate();
        detailInclude.getChildren().clear();

    }

    public static void showMenuItemNoClear(String url, Div mainInclude, Map map) {
        mainInclude.invalidate();
        mainInclude.getChildren().clear();
        Executions.createComponents(url, mainInclude, map);
    }

    public static void doPopup(Map map, String zulToOpen) {
        Executions.createComponents(zulToOpen, null, map);
    }

    public static Map<String, Object> doAfterCompose() {
        return Executions.getCurrent().getArg();
    }

    public static void lookupNmEks(Textbox nmEks, Textbox seqEks) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("seqEksKey", seqEks);
//        map.put(UIConstants.Criteria.TRPERUSAHAAN_NMPERUSAHAANEKS_PARENT, nmEks);
//        Executions.createComponents(UIConstants.Zul.POPUP_LOOKUP_NM_EKS, null, map);
    }

    public static void messageSummary(String msg, String title, String data) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        /*
        List error = (List) map.get("message");
        String title = (String) map.get("title_message");
        String head = (String) map.get("header_message");
        Integer valid=VUtil.nvlZero((Integer) map.get("valid_data"));
        Integer notvalid=VUtil.nvlZero((Integer) map.get("notvalid_data"));
         */
        map.put("message", msg);
        map.put("title_message", title);
        map.put("header_message", "Summary");
        map.put("data", data);
        Executions.createComponents(UIConstants.Zul.POPUP_MESSAGE_PROSES, null, map);
    }

    public static void lookupNmEksThreeForm(Textbox seqEks, Textbox kdId, Textbox idEks, Textbox nmEks, Textbox alEks) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("seqEks", seqEks);
        map.put("kdIdEks", kdId);
        map.put("idEks", idEks);
        map.put("nmEks", nmEks);
        map.put("alEks", alEks);
        Executions.createComponents(UIConstants.Zul.POPUP_LOOKUP_NM_EKS_THREE_FORM, null, map);
    }

    public static void lookupNmPpjk(Textbox nmPpjk, Textbox seqPpjk) {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("seqPpjkKey", seqPpjk);
//        map.put(UIConstants.Criteria.TRPERUSAHAAN_NMPERUSAHAANPPJK_PARENT, nmPpjk);
//        Executions.createComponents(UIConstants.Zul.POPUP_LOOKUP_NM_PPJK, null, map);
    }

    public static void lookupJenisUsaha(Textbox kdUsaha, Textbox urUsaha) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("kdUsaha", kdUsaha);
        map.put("urUsaha", urUsaha);
        Executions.createComponents("/ekspor/lookup/LookupJenisUsaha.zul", null, map);
    }

    public static ListModelList renderListbox(Listbox listbox, List list, ListitemRenderer listItemRender, Paging paging, int pagesize, int recordCount) {


        if (!StringUtil.isListNotEmpty(list)) {
            list = new ArrayList();
        }
        if (recordCount == 0) {
            paging.setVisible(false);
        } else {
            paging.setPageSize(pagesize);
            paging.setVisible(true);
            paging.setTotalSize(recordCount);
            paging.setDetailed(true);
        }

        ListModelList model = new ListModelList(list);
        listbox.setModel(new ListModelList(list));
        listbox.setItemRenderer(listItemRender);
        return model;
    }

    public static void MessageBoxInformation(String message, String title) {
        try {
            Messagebox.show(message, title, Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void MessageBoxError(String message, String title) {
        try {
            Messagebox.show(message, title, Messagebox.OK, Messagebox.ERROR);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

//    public static void setSession(String key, Object obj) {
//        Session session = Sessions.getCurrent();
//        session.setAttribute(key, obj);
//    }
//
//    public static Object getSession(String key) {
//        Session session = Sessions.getCurrent();
//        return session.getAttribute(key);
//    }
//
//    public static Object getRemoveSession(String key) {
//        Session session = Sessions.getCurrent();
//        Object obj = session.getAttribute(key);
//        System.out.println(key + " - " + obj);
//        removeSession(key);
//        return obj;
//    }
//
//    public static Object removeSession(String key) {
//        Session session = Sessions.getCurrent();
//        return session.removeAttribute(key);
//    }
    public static void setSession(String key, Object obj) {
        Desktop desktop = Executions.getCurrent().getDesktop();
        desktop.setAttribute(key, obj);
//        Session session = Sessions.getCurrent();
//        session.setAttribute(key, obj);
    }

    public static Object getSession(String key) {
        Desktop desktop = Executions.getCurrent().getDesktop();
        return desktop.getAttribute(key);
//        Session session = Sessions.getCurrent();
//        return session.getAttribute(key);
    }

    public static Object getRemoveSession(String key) {
//        Desktop desktop = Executions.getCurrent().getDesktop(); 
//        return desktop.getAttribute(key);
//        Session session = Sessions.getCurrent();
        Object obj = getSession(key);
        System.out.println(key + " - " + obj);
        removeSession(key);
        return obj;
    }

    public static Object removeSession(String key) {
        Desktop desktop = Executions.getCurrent().getDesktop();
        return desktop.removeAttribute(key);
    }

    /*
     * MessageBox.show(Question, YES | NO , ?)
     * if YES return true
     * if NO return False
     * 
     * u just put your question into the parameter
     */
    public static Boolean msgBox_YES_NO(String question) {
        Boolean cek = false;
        try {
            if (Messagebox.show(question,
                    "Konfirmasi", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
                cek = true;
                System.out.println("YES");
            } else {
                cek = false;
                System.out.println("NO");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(UIUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }

    public static List getListboxSelectedItems(Listbox listbox) {
        Set set = listbox.getSelectedItems();
        Iterator itr = set.iterator();
        List listObj = new ArrayList();
        while (itr.hasNext()) {
            Listitem obj = (Listitem) itr.next();
            listObj.add(obj.getAttribute("data"));
        }
        return listObj;
    }

    public static AbstractComponent findDeepComponent(Page parent, String id) {
        Desktop desktop = parent.getDesktop();
        for (Iterator i$ = desktop.getComponents().iterator(); i$.hasNext();) {
            Object o = i$.next();
            if ((o instanceof Component)) {
                Component c = (Component) o;
                if ((c.getId().equals(id)) && (c.getPage() == parent)) {
                    return (AbstractComponent) c;
                }
            }
        }
        return null;
    }

    public static void textHiLight(final Decimalbox textHighlight, final Decimalbox textSource) {
        if (textHighlight.getValue() != null && textSource.getValue() != null) {
            if (textHighlight.getValue().compareTo(textSource.getValue()) != 0) {
                textHighlight.setStyle("text-align:right;background:#FF8500;");
            } else if (textHighlight.getValue().compareTo(textSource.getValue()) == 0) {
                textHighlight.setStyle("text-align:right;");
            }
        }
    }

    public static void textHiLightInt(final Intbox textHighlight, final Intbox textSource) {
        if (textHighlight.getValue() != null && textSource.getValue() != null) {
            if (textHighlight.getValue().compareTo(textSource.getValue()) != 0) {
                textHighlight.setStyle("text-align:right;background:#FF8500;");
            } else if (textHighlight.getValue().compareTo(textSource.getValue()) == 0) {
                textHighlight.setStyle("text-align:right;");
            }
        }
    }

    public static void textHLightRight(final Textbox textHighlight, final Textbox textSource) {
        if (!VUtil.nvl(textHighlight.getValue(), "").equalsIgnoreCase(VUtil.nvl(textSource.getValue(), ""))) {
            textHighlight.setStyle("text-align:right;background:#FF8500;");
        } else if (VUtil.nvl(textHighlight.getValue(), "").equalsIgnoreCase(VUtil.nvl(textSource.getValue(), ""))) {
            textHighlight.setStyle("text-align:right;");
        }
    }

    public static void textHLightLeft(final Textbox textHighlight, final Textbox textSource) {
        if (!VUtil.nvl(textHighlight.getValue(), "").equalsIgnoreCase(VUtil.nvl(textSource.getValue(), ""))) {
            textHighlight.setStyle("text-align:left;background:#FF8500;");
        } else if (VUtil.nvl(textHighlight.getValue(), "").equalsIgnoreCase(VUtil.nvl(textSource.getValue(), ""))) {
            textHighlight.setStyle("text-align:left;");
        }
    }

    public static void textClearColorLeft(final Textbox textHighlight) {
        textHighlight.setStyle("text-align:left;");
    }

    public static void textClearColorRight(final Textbox textHighlight) {
        textHighlight.setStyle("text-align:right;");
    }

    public static void textClearColorRight(final Intbox textHighlight) {
        textHighlight.setStyle("text-align:right;");
    }

    public static void textClearColorRight(final Decimalbox textHighlight) {
        textHighlight.setStyle("text-align:right;");
    }
    private static DataSource dsEkspor;


    private static Connection conn = null;

    public static Connection getReportConnection() {
//        Connection conn = null;
//        try {
//            String url = "";
//            Class.forName(UIConstants.ReportConnection.NAME);
//            conn = DriverManager.getConnection(url, UIConstants.ReportConnection.CONN_USER, UIConstants.ReportConnection.CONN_PSWD);
//            System.out.println("***************************************************");
//            System.out.println("REPORT");
//            System.out.println("***************************************************");
//            System.out.println("url = " + url);
//            System.out.println("driver = " + UIConstants.ReportConnection.NAME);
//            System.out.println("user = " + UIConstants.ReportConnection.CONN_USER);
//            System.out.println("passwd = " + UIConstants.ReportConnection.CONN_PSWD);
//            System.out.println("conn = " + conn);
//            if (conn == null) {
//                conn = getEksporDS().getConnection();
//            } else if (conn.isClosed()) {
//                conn = getEksporDS().getConnection();
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ZKUtil.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(ZKUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return conn;
    }
}
