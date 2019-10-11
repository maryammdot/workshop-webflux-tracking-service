package com.github.alextremp.pulse.application.savepulses;

import com.github.alextremp.pulse.application.savepulses.io.PulseEvent;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesResponse;
import com.github.alextremp.pulse.domain.pulse.Pulse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class SavePulsesUseCase {

  public Mono<SavePulsesResponse> savePulses(SavePulsesRequest request) {
    try {
      createPulses(request);
      return Mono.just(SavePulsesResponse.processed());
    } catch (Throwable error) {
      return Mono.just(SavePulsesResponse.error(error));
    }
  }

  private void createPulses(SavePulsesRequest request) {
    String id = UUID.randomUUID().toString();
    String clientId = request.getId();
    int i;
    for(i = 0; i< request.getEvents().length; i++) {
      PulseEvent pulseEvent = request.getEvents()[i];
      new Pulse(id, clientId, pulseEvent.getName(), pulseEvent.getPayload());
    }
  }
}
