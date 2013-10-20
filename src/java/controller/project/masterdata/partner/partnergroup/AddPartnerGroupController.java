package controller.project.masterdata.partner.partnergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import pohaci.gumunda.titis.hrm.dbapi.IDBConstants;
import pohaci.gumunda.titis.project.cgui.CompanyGroup;
import pohaci.gumunda.titis.project.logic.ProjectBusinessLogic;
import util.ConnectionUtil;

/* @author Tata */
public class AddPartnerGroupController extends GenericForwardComposer {
	Window  windowAddPartnerGroup;
	Textbox  description,name;
	Toolbarbutton  btnSavePartnerGroup,btnCancelPartnerGroup;

	ShowPartnerGroupController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPartnerGroupController) map.get("parent");
		windowAddPartnerGroup.doModal();
	}

	public void onClick$btnCancelPartnerGroup() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddPartnerGroup.onClose();
	}

	public void onClick$btnSavePartnerGroup() {
		try
		{
			CompanyGroup cGroup = new CompanyGroup(1, name.getValue(), description.getValue());
                        ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).createPartnerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, cGroup);	
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}