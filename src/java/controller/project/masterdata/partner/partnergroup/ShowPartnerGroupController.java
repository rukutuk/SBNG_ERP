package controller.project.masterdata.partner.partnergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.partner.partnergroup.ShowPartnerGroupRenderer;
import org.zkoss.zk.ui.Executions;import org.zkoss.zul.ListModelList;
;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.customer.customergroup.ShowCustomerGroupRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import renderer.hrm.masterdata.customer.customergroup.ShowCustomerGroupRenderer;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import util.ConnectionUtil;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.project.dbapi.IDBConstants;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowPartnerGroupController extends GenericForwardComposer {
	Window  windowShowPartnerGroup;
	Listbox  listboxPartnerGroup;
	Toolbarbutton  btnAddPartnerGroup,btnEditPartnerGroup,btnDeletePartnerGroup;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
                    listboxPartnerGroup.setItemRenderer(new ShowPartnerGroupRenderer());
                    listboxPartnerGroup.setModel(new ListModelList(ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).getAllPartnerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        

	public void onClick$btnAddPartnerGroup() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/partner/partnergroup/add_partner_group.zul", null, map);
	}

	public void onClick$btnEditPartnerGroup() {
		if (listboxPartnerGroup.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
                        map.put("obj", ((CompanyGroup)listboxPartnerGroup.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/partner/partnergroup/edit_partner_group.zul", null, map);
		}
	}

	public void onClick$btnDeletePartnerGroup() {
		if (listboxPartnerGroup.getSelectedItem() != null)
		{
                     CompanyGroup cGroup = (CompanyGroup)listboxPartnerGroup.getSelectedItem().getAttribute("data");
                       try {
                        ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).deletePartnerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, cGroup.getIndex());
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}