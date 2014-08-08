package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HouseHoldContractRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class HouseHoldContractRequest {
	
	@XmlElement(name="Personendaten")
	private Personendaten 		person;
	@XmlElement(name="VersichertesObjekt")
	private VersichertesObjekt 	object;
	@XmlElement(name="Vertrag")
	private Vertrag 			contract;
	
	public HouseHoldContractRequest(Personendaten person,
			VersichertesObjekt object, Vertrag contract) {
		super();
		this.person = person;
		this.object = object;
		this.contract = contract;
	}
	
	public HouseHoldContractRequest( ) {
		super();
		Personendaten person = new Personendaten("", "", "", new java.util.Date(), "", "", 1, "", "", "", "");
		VersichertesObjekt object = new VersichertesObjekt(new java.util.Date(), 200, "efh", "", 1, "");
		Vertrag contract = new Vertrag(0.0, 0, "Premium", "");
	}

	public HouseHoldContractRequest getMe() {
		return this;
	}

	/**
	 * @return the person
	 */
	public Personendaten getPerson() {
		return person;
	}
	
	/**
	 * @param person the person to set
	 */
	public void setPerson(Personendaten person) {
		this.person = person;
	}
	
	/**
	 * @return the object
	 */
	public VersichertesObjekt getObject() {
		return object;
	}
	
	/**
	 * @param object the object to set
	 */
	public void setObject(VersichertesObjekt object) {
		this.object = object;
	}
	
	/**
	 * @return the contract
	 */
	public Vertrag getContract() {
		return contract;
	}
	
	/**
	 * @param contract the contract to set
	 */
	public void setContract(Vertrag contract) {
		this.contract = contract;
	}
	
	

}
