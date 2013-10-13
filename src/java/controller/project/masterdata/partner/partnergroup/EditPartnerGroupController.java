package controller.project.masterdata.partner.partnergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditPartnerGroupController extends GenericForwardComposer {
	Window  windowEditPartnerGroup;
	Textbox  description,name;
	Toolbarbutton  btnSavePartnerGroup,btnCancelPartnerGroup;

	ShowPartnerGroupController parent;
	// PartnerGroup partnerGroup = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPartnerGroupController) map.get("parent");
		// partnerGroup = (PartnerGroup) map.get("obj");
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
			// PartnerGroup partnerGroup = new PartnerGroup();
			// partnerGroup.setDescription(description.getValue());
			// partnerGroup.setName(name.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}