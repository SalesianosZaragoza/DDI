package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Owner;

public class OwnerAssembler {

	public static Owner assembleOwnerFrom(HttpServletRequest req) {
		Owner owner = new Owner();
		String codOwner=req.getParameter("codOwner");
		if(null != codOwner) {
			owner.setCodOwner(Integer.parseInt(codOwner));
		}
		String name = req.getParameter("name");
		String lastname = req.getParameter("surname");
		owner.setName(name);
		owner.setSurname(lastname);
		return owner;
	}
}