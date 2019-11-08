package com.github.alextremp.pulse.domain.pulse;

import com.github.alextremp.pulse.domain.pulse.error.MandatoryFieldException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Pulse {
  private final String id;
  private final String clientId;
  private final String name;
  private final Map<String, Object> payload;

  public Pulse(String id, String clientId, String name, Map<String, Object> payload) {
    if (StringUtils.isBlank(id)) {
      throw new MandatoryFieldException("Id");
    }
    if (StringUtils.isBlank(clientId)) {
      throw new MandatoryFieldException("Client Id");
    }
    if (StringUtils.isBlank(name)) {
      throw new MandatoryFieldException("Name");
    }
    this.id = id;
    this.clientId = clientId;
    this.name = name;
    this.payload = payload;
  }

  public String getId() {
    return id;
  }

  public String getClientId() {
    return clientId;
  }

  public String getName() {
    return name;
  }

  public Map<String, Object> getPayload() {
    return payload;
  }

  @Override
  public String toString() {
    // PULSE | pulse_id: {pulse.id} | pulse_clientId: {pulse.clientId} | pulse_name: {pulse.name} | *{pulse.payload.key}: {pulse.payload.value}
    return "PULSE | " +
        "pulse_id: {" + id + '}' +
        " | pulse_clientId: {" + clientId + '}' +
        " | pulse_name: {" + name + '}' +
        " | *{pulse.payload.key}: {" + payload.toString() +
        '}';
  }
}
