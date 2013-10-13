package controller.project.masterdata.partner.partnerdata;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.partner.partnerdata.ShowPartnerRenderer;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowPartnerController extends GenericForwardComposer {
	Window  windowShowPartner;
	Listbox  listboxPartner;
	Toolbarbutton  btnAddPartner,btnEditPartner,btnDeletePartner;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
			// ZKUtil.renderListbox(listboxPartner, NUNUNG , new ShowPartnerRenderer());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddPartner() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/partner/partnerdata/add_partner.zul", null, map);
	}

	public void onClick$btnEditPartner() {
		if (listboxPartner.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			// NUNUNG
			// map.put("obj", ((Partner)listboxPartner.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/partner/partnerdata/edit_partner.zul", null, map);
		}
	}

	public void onClick$btnDeletePartner() {
		if (listboxPartner.getSelectedItem() != null)
		{
			// NUNUNG
			// Partner Partner = (Partner)listboxPartner.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}