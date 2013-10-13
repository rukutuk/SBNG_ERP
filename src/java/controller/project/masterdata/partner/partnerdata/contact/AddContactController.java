package controller.project.masterdata.partner.partnerdata.contact;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class AddContactController extends GenericForwardComposer {
	Window  windowAddContact;
	Textbox  city,code,email,fax1,firstname,phone1,street,website;
	Intbox  postalcode,personalindex;
	Toolbarbutton  btnSaveContact,btnCancelContact;

	ShowContactController parent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowContactController) map.get("parent");
		windowAddContact.doModal();
	}

	public void onClick$btnCancelContact() {
		closeWindow();
	}

	public void closeWindow() {
		windowAddContact.onClose();
	}

	public void onClick$btnSaveContact() {
		try
		{
			// Contact Contact = new Contact();
			// Contact.setCity(city.getValue());
			// Contact.setCode(code.getValue());
			// Contact.setEmail(email.getValue());
			// Contact.setFax1(fax1.getValue());
			// Contact.setFirstname(firstname.getValue());
			// Contact.setPhone1(phone1.getValue());
			// Contact.setPostalcode(postalcode.getValue());
			// Contact.setStreet(street.getValue());
			// Contact.setWebsite(website.getValue());
			// Contact.setPersonalindex(personalindex.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}