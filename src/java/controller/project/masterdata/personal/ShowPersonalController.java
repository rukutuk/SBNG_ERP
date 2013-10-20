package controller.project.masterdata.personal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.personal.ShowPersonalRenderer;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import util.ConnectionUtil;
import org.zkoss.zul.Listbox;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.logic.HRMBusinessLogic;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.cgui.Personal;

/* @author Tata */
public class ShowPersonalController extends GenericForwardComposer {
	Window  windowShowPersonal;
	Listbox  listboxPersonal;
	Toolbarbutton  btnAddPersonal,btnEditPersonal,btnDeletePersonal;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
                    listboxPersonal.setItemRenderer(new ShowPersonalRenderer());
                    listboxPersonal.setModel(new ListModelList(ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllPersonal(0, IDBConstants.MODUL_MASTER_DATA)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddPersonal() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/personal/add_personal.zul", null, map);
	}

	public void onClick$btnEditPersonal() {
		if (listboxPersonal.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			// NUNUNG
			// map.put("obj", ((Personal)listboxPersonal.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/personal/edit_personal.zul", null, map);
		}
	}

	public void onClick$btnDeletePersonal() {
		if (listboxPersonal.getSelectedItem() != null)
		{
			Personal rv = (Personal)listboxPersonal.getSelectedItem().getAttribute("data");
                    try {
			ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deletePersonal(0, IDBConstants.MODUL_MASTER_DATA, rv.getIndex());	
                        prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}