package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Pet;

public class PetAssembler {
	public static Pet assemblePetFrom(HttpServletRequest req) {
		Pet pet = new Pet();
		String codOwner=req.getParameter("codOwner");
		String name=req.getParameter("name");
		if(null != codOwner) {
			pet.setCodOwner(Integer.parseInt(codOwner));
		}
		pet.setName(name);
		return pet;
	}
}
