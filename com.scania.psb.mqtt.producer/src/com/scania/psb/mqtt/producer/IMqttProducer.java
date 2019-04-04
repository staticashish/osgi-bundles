package com.scania.psb.mqtt.producer;

import org.eclipse.kura.KuraException;

public interface IMqttProducer {
	void publish(String topic, String clientId, String data) throws KuraException;
}
