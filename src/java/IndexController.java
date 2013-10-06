
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.ComponentNotFoundException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tata
 */
public class IndexController extends GenericForwardComposer{

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
//        alert("JREBEL.com");
        onClick$HR_041();
    }
    
//    START Project Monitoring
    
    public void onClick$PM_003(Event e) {
        try {
            showPage("/project/registration/project_list.zul", "PM_003", "Project List");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void onClick$PM_005(Event e) {
        try {
            showPage("/project/monitoring/project_monitoring.zul", "PM_005", "Project Monitoring");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void onClick$PM_007(Event e) {
        try {
            showPage("/project/timesheet/project_timesheet.zul", "testing", "Testing");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void onClick$PM_009(Event e) {
//        try {
//            showPage("/project/expensesheet/project_timesheet.zul", "testing", "Testing");
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
    }
    
//    END Project Monitoring
    
//    START HR
    public void onClick$HR_003(Event e) {
        try {
            showPage("/hrm/employee/data/show_employee.zul", "HR_003", "Employee Data");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void onClick$HR_006(Event e) {
        try {
            showPage("/hrm/absence/leavepermission/show_leave_permission.zul", "HR_006", "Leave and Permission");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
//    public void onClick$HR_041(Event e) {
    public void onClick$HR_041() {
        try {
            showPage("/hrm/masterdata/payroll/ptkp/show_ptkp.zul", "HR_006", "PTKP");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
//    END HR
    
    
    private void showPage(String zulFilePathName, String tabID, String tabLabel) throws InterruptedException {

        try {
            // TODO get the parameter for working with tabs from the application
            // params
            final int workWithTabs = 1;

            if (workWithTabs == 1) {

                /* get an instance of the borderlayout defined in the zul-file */
                final Borderlayout bl = (Borderlayout) Path.getComponent("/outerIndexWindow/borderlayoutMain");
                /* get an instance of the searched CENTER layout area */
                final Center center = bl.getCenter();
                // get the tabs component
                final Tabs tabs = (Tabs) center.getFellow("divCenter").getFellow("tabBoxIndexCenter").getFellow("tabsIndexCenter");

                /**
                 * Check if the tab is already opened than select them and<br>
                 * go out of here. If not than create them.<br>
                 */
                Tab checkTab = null;
                try {
                    // checkTab = (Tab) tabs.getFellow(tabName);
                    checkTab = (Tab) tabs.getFellow("tab_" + tabID.trim());
                    checkTab.setSelected(true);
                } catch (final ComponentNotFoundException ex) {
                    // Ignore if can not get tab.
                }

                if (checkTab == null) {

                    final Tab tab = new Tab();
                    tab.setId("tab_" + tabID.trim());

                    if (tabLabel != null) {
                        tab.setLabel(tabLabel.trim());
                    } else {
                        tab.setLabel(tabLabel.trim());
                    }
                    tab.setClosable(true);
                    tab.setParent(tabs);

                    final Tabpanels tabpanels = (Tabpanels) center.getFellow("divCenter").getFellow("tabBoxIndexCenter").getFellow("tabsIndexCenter").getFellow("tabpanelsBoxIndexCenter");
                    final Tabpanel tabpanel = new Tabpanel();
                    tabpanel.setHeight("100%");
                    tabpanel.setStyle("padding: 0px;");
                    tabpanel.setParent(tabpanels);

                    /*
                     * create the page and put it in the tabs area
                     */
                    Executions.createComponents(zulFilePathName, tabpanel, null);
                    tab.setSelected(true);
                }
            } else {
                /* get an instance of the borderlayout defined in the zul-file */
                final Borderlayout bl = (Borderlayout) Path.getComponent("/outerIndexWindow/borderlayoutMain");
                /* get an instance of the searched CENTER layout area */
                final Center center = bl.getCenter();
                /* clear the center child comps */
                center.getChildren().clear();
                /*
                 * create the page and put it in the center layout area
                 */
                Executions.createComponents(zulFilePathName, center, null);
            }

//			if (logger.isDebugEnabled()) {
//				logger.debug("--> calling zul-file: " + zulFilePathName);
//			}
        } catch (final Exception e) {
            Messagebox.show(e.toString());
        }
    }    
    
    
}
