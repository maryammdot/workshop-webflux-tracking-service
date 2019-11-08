package com.github.alextremp.pulse.application.savepulses;

import com.github.alextremp.pulse.application.savepulses.io.PulseMapper;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesResponse;
import reactor.core.publisher.Mono;

public class SavePulsesUseCase {

  public SavePulsesResponse savePulses(SavePulsesRequest request) {
      try {
          new PulseMapper().map(request);
          return SavePulsesResponse.processed();
        } catch(RuntimeException error) {
          return SavePulsesResponse.error(error);
        }
  }
}
