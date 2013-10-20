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
public class EditPartnerGroupController extends GenericForwardComposer {
	Window  windowEditPartnerGroup;
	Textbox  description,name;
	Toolbarbutton  btnSavePartnerGroup,btnCancelPartnerGroup;

	ShowPartnerGroupController parent;
	CompanyGroup partnerGroup = null;
        long idx = -1;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPartnerGroupController) map.get("parent");
		// partnerGroup = (PartnerGroup) map.get("obj");
//        idx = (Long) map.get("obj");
            partnerGroup = (CompanyGroup) map.get("obj");
            idx = partnerGroup.getIndex();
        
            name.setValue(partnerGroup.getName() );
            description.setValue(partnerGroup.getDescription());
		windowEditPartnerGroup.doModal();
	}

	public void onClick$btnCancelPartnerGroup() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditPartnerGroup.onClose();
	}

	public void onClick$btnSavePartnerGroup() {
		try
		{
			CompanyGroup cGroup = new CompanyGroup(idx, name.getValue(), description.getValue());
                        ProjectBusinessLogic.getInstance(ConnectionUtil.getInstance().getConn()).updatePartnerCompanyGroup(0, IDBConstants.MODUL_MASTER_DATA, idx, cGroup);
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}