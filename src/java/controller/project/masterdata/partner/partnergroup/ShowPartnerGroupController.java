package controller.project.masterdata.partner.partnergroup;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.partner.partnergroup.ShowPartnerGroupRenderer;
import org.zkoss.zk.ui.Executions;;
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
			// ZKUtil.renderListbox(listboxPartnerGroup, NUNUNG , new ShowPartnerGroupRenderer());
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
			// NUNUNG
			// map.put("obj", ((PartnerGroup)listboxPartnerGroup.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/partner/partnergroup/edit_partner_group.zul", null, map);
		}
	}

	public void onClick$btnDeletePartnerGroup() {
		if (listboxPartnerGroup.getSelectedItem() != null)
		{
			// NUNUNG
			// PartnerGroup partnerGroup = (PartnerGroup)listboxPartnerGroup.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}