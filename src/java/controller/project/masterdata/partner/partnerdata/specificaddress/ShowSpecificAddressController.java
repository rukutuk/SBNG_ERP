package controller.project.masterdata.partner.partnerdata.specificaddress;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.partner.partnerdata.specificaddress.ShowSpecificAddressRenderer;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowSpecificAddressController extends GenericForwardComposer {
	Window  windowShowSpecificAddress;
	Listbox  listboxSpecificAddress;
	Toolbarbutton  btnAddSpecificAddress,btnEditSpecificAddress,btnDeleteSpecificAddress;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
			// ZKUtil.renderListbox(listboxSpecificAddress, NUNUNG , new ShowSpecificAddressRenderer());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddSpecificAddress() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/partner/partnerdata/specificaddress/add_specific_address.zul", null, map);
	}

	public void onClick$btnEditSpecificAddress() {
		if (listboxSpecificAddress.getSelectedItem() != null)
		{
			Map map = new HashMap();
			map.put("parent", this);
			// NUNUNG
			// map.put("obj", ((SpecificAddress)listboxSpecificAddress.getSelectedItem().getAttribute("data")));
			Executions.createComponents("/project/masterdata/partner/partnerdata/specificaddress/edit_specific_address.zul", null, map);
		}
	}

	public void onClick$btnDeleteSpecificAddress() {
		if (listboxSpecificAddress.getSelectedItem() != null)
		{
			// NUNUNG
			// SpecificAddress specificAddress = (SpecificAddress)listboxSpecificAddress.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}