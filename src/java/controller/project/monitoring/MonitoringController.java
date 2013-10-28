package controller.project.monitoring;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import pohaci.gumunda.titis.project.cgui.SearchProjectDlg.SearchTable;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import renderer.project.monitoring.NotesListRenderer;
import renderer.project.monitoring.ProgressListRenderer;
import util.ConnectionUtil;

/* @author Tata */
public class MonitoringController extends GenericForwardComposer {

    Window windowProjectList;
    Toolbarbutton btnAdd, btnEdit, btnDelete;
    Listbox listboxProgress, listboxNotes, listboxBdProjectCode;
    Textbox textCustomer;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        prepareList();
    }

    private void prepareList() {
        try {
            Connection conn = ConnectionUtil.getInstance().getConn();
            ProjectBusinessLogic logic = ProjectBusinessLogic.getInstance(conn);
            listboxProgress.setItemRenderer(new ProgressListRenderer());
            listboxProgress.setModel(new ListModelList(logic.getProjectProgress(0, IDBConstants.MODUL_PROJECT_MANAGEMENT,1)));
            
            listboxNotes.setItemRenderer(new NotesListRenderer());
            listboxNotes.setModel(new ListModelList(logic.getProjectNotes(0,IDBConstants.MODUL_PROJECT_MANAGEMENT, 1)));
            
            listboxBdProjectCode.setItemRenderer(new renderer.project.monitoring.ProjectListRenderer());            
            listboxBdProjectCode.setModel(new ListModelList(logic.getProjectDataByCriteria(0,IDBConstants.MODUL_MASTER_DATA, getQueryProject())));
            setMonitoringProject();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(MonitoringController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setMonitoringProject(){
        textCustomer.setValue("nungky");
    }

    public void onClick$btnAdd() {
        alert("Test");
    }
    
    private String getQueryProject(){
      java.util.Date date = new java.util.GregorianCalendar().getTime();         
      java.text.DateFormat formatDate = new java.text.SimpleDateFormat( "yyyy-MM-dd" );
      String tgl = formatDate.format(date);
      String operator, criteria = "";
      int row = 0;
      String queryselect = "SELECT * FROM (" + 
    	  	"SELECT pd." + IDBConstants.ATTR_AUTOINDEX +
      		", pd." + IDBConstants.ATTR_CODE +
      		", cust." + IDBConstants.ATTR_NAME + " AS CUSTOMERNAME" +
      		", pd." + IDBConstants.ATTR_WORK_DESCRIPTION +
      		", act." + IDBConstants.ATTR_NAME + " AS ACTIVITYNAME" +
      		", pd." + IDBConstants.ATTR_ORNO +
      		", pd." + IDBConstants.ATTR_ORDATE +
      		", pd." + IDBConstants.ATTR_PONO  +
      		", pd." + IDBConstants.ATTR_PODATE +
      		", pd." + IDBConstants.ATTR_IPCNO + 
      		", pd." + IDBConstants.ATTR_IPCDATE +
      		", pc." + IDBConstants.ATTR_ACTUAL_START_DATE +
      		", pc." + IDBConstants.ATTR_ACTUAL_END_DATE +
      		", pc." + IDBConstants.ATTR_VALIDATION +
      		", pd." + IDBConstants.ATTR_REGDATE +
      		", pd." + IDBConstants.ATTR_CUSTOMER +
      		", pd." + IDBConstants.ATTR_UNIT +
      		", pd." + IDBConstants.ATTR_FILE + 
      		", pd." + IDBConstants.ATTR_SHEET +
      		", pd." + IDBConstants.ATTR_ACTIVITY +
      		", pd." + IDBConstants.ATTR_DEPARTMENT + " ";
      
      String querytable = "FROM " + IDBConstants.TABLE_PROJECT_DATA + " pd " +
      		"LEFT JOIN " + IDBConstants.TABLE_CUSTOMER + " cust " +
      		"ON pd." + IDBConstants.ATTR_CUSTOMER + "=cust." + IDBConstants.ATTR_AUTOINDEX + " " +
      		"LEFT JOIN " + IDBConstants.TABLE_ACTIVITY + " act " +
      		"ON pd." + IDBConstants.ATTR_ACTIVITY + "=act." + IDBConstants.ATTR_AUTOINDEX + " " +
      		"LEFT JOIN " + IDBConstants.TABLE_PROJECT_CONTRACT + " pc " +
      		"ON pd." + IDBConstants.ATTR_AUTOINDEX + "=pc." + IDBConstants.ATTR_PROJECT + ") proj";
      String query = queryselect + querytable + criteria + " ORDER BY " + IDBConstants.ATTR_CODE;
      return query;
    }
}