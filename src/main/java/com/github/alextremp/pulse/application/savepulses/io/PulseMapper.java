package com.github.alextremp.pulse.application.savepulses.io;

import com.github.alextremp.pulse.domain.pulse.Pulse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PulseMapper {
  public List<Pulse> map(SavePulsesRequest request) {
    if(request.getEvents() == null) {
      return new ArrayList<>();
    }

    return Arrays.stream(request.getEvents())
      .map(pulseEvent -> mapPulse(request, pulseEvent)).collect(Collectors.toList());
  }

  private Pulse mapPulse(SavePulsesRequest request, PulseEvent pulseEvent) {
    return new Pulse(
        UUID.randomUUID().toString(),
        request.getId(),
        pulseEvent.getName(),
        pulseEvent.getPayload()
    );
  }
}
