package controller.project.masterdata.personal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Toolbarbutton;

/* @author Tata */
public class EditPersonalController extends GenericForwardComposer {
	Window  windowEditPersonal;
	Datebox  birthdate;
	Textbox  birthplace,city,code,country,email,fax1,fax2,firstname,lastname,nickname,phone1,phone2,province,street,title,website;
	Intbox  postalcode;
	Toolbarbutton  btnSavePersonal,btnCancelPersonal;

	ShowPersonalController parent;
	// Personal Personal = null;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Map map = Executions.getCurrent().getArg();
		parent = (ShowPersonalController) map.get("parent");
		// Personal = (Personal) map.get("obj");
		windowEditPersonal.doModal();
	}

	public void onClick$btnCancelPersonal() {
		closeWindow();
	}

	public void closeWindow() {
		windowEditPersonal.onClose();
	}

	public void onClick$btnSavePersonal() {
		try
		{
			// Personal Personal = new Personal();
			// Personal.setBirthdate(birthdate.getValue());
			// Personal.setBirthplace(birthplace.getValue());
			// Personal.setCity(city.getValue());
			// Personal.setCode(code.getValue());
			// Personal.setCountry(country.getValue());
			// Personal.setEmail(email.getValue());
			// Personal.setFax1(fax1.getValue());
			// Personal.setFax2(fax2.getValue());
			// Personal.setFirstname(firstname.getValue());
			// Personal.setLastname(lastname.getValue());
			// Personal.setNickname(nickname.getValue());
			// Personal.setPhone1(phone1.getValue());
			// Personal.setPhone2(phone2.getValue());
			// Personal.setPostalcode(postalcode.getValue());
			// Personal.setProvince(province.getValue());
			// Personal.setStreet(street.getValue());
			// Personal.setTitle(title.getValue());
			// Personal.setWebsite(website.getValue());
			// NUNUNG
			parent.prepareList();
			closeWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}