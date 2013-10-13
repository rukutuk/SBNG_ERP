package controller.project.masterdata.partner.partnerdata.contact;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import util.ZKUtil;
import java.util.Map;
import java.util.HashMap;
import renderer.project.masterdata.partner.partnerdata.contact.ShowContactRenderer;
import org.zkoss.zk.ui.Executions;;
import org.zkoss.zul.Window;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class ShowContactController extends GenericForwardComposer {
	Window  windowShowContact;
	Listbox  listboxContact;
	Toolbarbutton  btnAddContact,btnEditContact,btnDeleteContact;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		prepareList();
	}

	public void prepareList() {
		try {
			// ZKUtil.renderListbox(listboxContact, NUNUNG , new ShowContactRenderer());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onClick$btnAddContact() {
		Map map = new HashMap();
		map.put("parent", this);
		Executions.createComponents("/project/masterdata/partner/partnerdata/contact/add_contact.zul", null, map);
	}

	public void onClick$btnDeleteContact() {
		if (listboxContact.getSelectedItem() != null)
		{
			// NUNUNG
			// Contact Contact = (Contact)listboxContact.getSelectedItem().getAttribute("data");
			try {
				// NUNUNG
				prepareList();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}