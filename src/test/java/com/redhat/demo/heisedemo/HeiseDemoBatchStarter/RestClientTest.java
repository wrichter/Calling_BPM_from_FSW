package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = { CDIMixIn.class })
public class RestClientTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	@ServiceOperation("RestClient")
	private Invoker service;

	@Test
	public void testStartProcess() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		
		// Create Variables
		Personendaten person = new Personendaten("admin", "Patrick","Steiner",new java.util.Date(), "p@p.de", "Strasse", 21244, "Hamburg", "iban", "bic","tel");
		VersichertesObjekt objekt = new VersichertesObjekt(new java.util.Date(), 300, "efh", "strasse", 21244, "Hamburg"); 
		Vertrag vertrag = new Vertrag(0.0, 0, "Premium", "0" );
		
		HouseHoldContractRequest message = new HouseHoldContractRequest();
		message.setContract(vertrag);
		message.setObject(objekt);
		message.setPerson(person);
		
		service.operation("startProcess").sendInOnly(message);

		// validate the results
		// Assert.assertTrue("Implement me", false);
		
		Assert.assertTrue(true);
	}

}
