package controller.project.registration;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Listbox;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import renderer.project.registration.ProjectListRenderer;
import util.ConnectionUtil;

/* @author Tata */
public class ProjectListController extends GenericForwardComposer {

    Window windowProjectList;
    Toolbarbutton btnAdd, btnEdit, btnDelete;
    Listbox listboxProject;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        prepareList();
    }

    private void prepareList() {
        try {
            Connection conn = ConnectionUtil.getInstance().getConn();
            ProjectBusinessLogic logic = ProjectBusinessLogic.getInstance(conn);
            listboxProject.setItemRenderer(new ProjectListRenderer());
            listboxProject.setModel(new ListModelList(logic.getAllProjectData(0, IDBConstants.MODUL_PROJECT_MANAGEMENT)));
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ProjectListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onClick$btnAdd() {
        alert("Test");
    }

    public void getListProject() {
        String projectCode = "001";
        String customer = "Nungky";
        project p = new project(projectCode, customer);
    }

    public class project {

        String m_customer = "";
        String m_projectCode = "";

        public project(String _projectCode, String _customer) {
            m_customer = _customer;
            m_projectCode = _projectCode;
        }

        public String getCustomer() {
            return m_customer;
        }

        public String getProjectCode() {
            return m_projectCode;
        }
    }
}