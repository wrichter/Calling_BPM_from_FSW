package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;

import java.net.MalformedURLException;
import java.net.URL;

import org.kie.services.client.api.RemoteRestRuntimeFactory;
import org.switchyard.component.bean.Service;

@Service(SingleContractRequestStarter.class)
public class SingleContractRequestStarterBean implements
		SingleContractRequestStarter {

	@Override
	public void startProcess(HouseHoldContractRequest request) {
		RemoteRestRuntimeFactory restSessionFactory;

		System.out.println(" ..........  foo 1...............");
		System.out.println(request);
		System.out.println(request.getPerson().getNachname());
		System.out.println(" ..........  foo 1...............");
		
		
		try {
			restSessionFactory = new RemoteRestRuntimeFactory("com.redhat.demo:HeiseDemo:1.4", // this can be viewed from business-central -> properties of deployed Process
															new URL("http://localhost:8280/business-central"), 
																	"psteiner", "change12_me");
//			
//			// create REST request
//			RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
//			KieSession ksession = engine.getKieSession();
//	
//			Map<String, Object> params = new HashMap<String, Object>();
//	
//			params.put("personendaten", request.getPerson());
//			params.put("versichertesObjekt", request.getObject());
//			params.put("vertrag", request.getContract());
//			
//			System.out.println(" ..........  foo 2...............");
//			System.out.println(request.getPerson().getVorname());
//			System.out.println(" ..........  foo 3...............");
//			
//			
////			ProcessInstance processInstance = ksession.startProcess("HeiseDemo.Hausrat", params);
//		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}


		
	}
	
	

}
