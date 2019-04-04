package com.scania.psb.mqtt.producer.provider;

import java.util.Date;

import org.eclipse.kura.KuraException;
import org.eclipse.kura.cloud.CloudClient;
import org.eclipse.kura.cloud.CloudClientListener;
import org.eclipse.kura.cloud.CloudService;
import org.eclipse.kura.message.KuraPayload;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scania.psb.mqtt.producer.IMqttProducer;

@Component
public class MqttProducer implements CloudClientListener, IMqttProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MqttProducer.class);
	private CloudService cloudService;
	private CloudClient cloudClient;
	
	@Override
	public void publish(String topic, String clientId, String data) throws KuraException {
		cloudClient = cloudService.newCloudClient(clientId);
    	KuraPayload payload = new KuraPayload();
    	payload.setTimestamp(new Date());
		payload.addMetric("data", data);
		this.cloudClient.publish(topic, payload, 0, false);
		cloudClient.release();
		LOGGER.info("topic : {} --- clientId : {} --- data : {} ", topic, clientId, data);
	}

	@Reference
	void bindCloudService(CloudService cloudService) {
		this.cloudService = cloudService;
	}

	@Override
	public void onConnectionEstablished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onControlMessageArrived(String arg0, String arg1, KuraPayload arg2, int arg3, boolean arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageArrived(String arg0, String arg1, KuraPayload arg2, int arg3, boolean arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageConfirmed(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessagePublished(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
}
