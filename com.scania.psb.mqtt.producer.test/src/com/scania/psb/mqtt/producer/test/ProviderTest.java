package com.scania.psb.mqtt.producer.test;

import org.eclipse.kura.KuraException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scania.psb.mqtt.producer.IMqttProducer;


@Component
public class ProviderTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProviderTest.class);
	private static final String APP_ID = "com.scania.psb.mqtt.producer.provider.test";
	private IMqttProducer mqttProducer;
	
	@Activate
	protected void activate(ComponentContext componentContext) throws KuraException {
        LOGGER.info("Bundle " + APP_ID + " has started !!");
			mqttProducer.publish("TOPIC-1", "CLIENT-1", "DATA-1");
    }
	
	@Deactivate
	protected void deactivate(ComponentContext componentContext) {
    	LOGGER.info("Bundle " + APP_ID + " has stopped !!");
    }
	
	@Reference
	void bindMqttProducer(IMqttProducer mqttProducer) {
		this.mqttProducer = mqttProducer;
	}
}
