package controller.project.masterdata.partner.partnerdata;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditPartnerController extends GenericForwardComposer {
	Window  windowEditPartner;
	Textbox  city,code,country,email,fax1,fax2,name,phone1,phone2,province,street,website;
	Intbox  postalcode,groupindex;
	Toolbarbutton  btnSavePartner,btnCancelPartner;

	ShowPartnerController parent;
	// Partner Partner = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPartnerController) map.get("parent");
		// Partner = (Partner) map.get("obj");
		windowEditPartner.doModal();
	}

	public void onClick$btnCancelPartner() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditPartner.onClose();
	}

	public void onClick$btnSavePartner() {
		try
		{
			// Partner Partner = new Partner();
			// Partner.setCity(city.getValue());
			// Partner.setCode(code.getValue());
			// Partner.setCountry(country.getValue());
			// Partner.setEmail(email.getValue());
			// Partner.setFax1(fax1.getValue());
			// Partner.setFax2(fax2.getValue());
			// Partner.setName(name.getValue());
			// Partner.setPhone1(phone1.getValue());
			// Partner.setPhone2(phone2.getValue());
			// Partner.setPostalcode(postalcode.getValue());
			// Partner.setProvince(province.getValue());
			// Partner.setStreet(street.getValue());
			// Partner.setWebsite(website.getValue());
			// Partner.setGroupindex(groupindex.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}