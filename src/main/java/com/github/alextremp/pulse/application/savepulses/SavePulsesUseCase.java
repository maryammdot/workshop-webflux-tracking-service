package com.github.alextremp.pulse.application.savepulses;

import com.github.alextremp.pulse.application.savepulses.io.PulseMapper;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesResponse;
import com.github.alextremp.pulse.domain.pulse.Pulse;
import com.github.alextremp.pulse.infrastructure.framework.controller.PulseController;
import java.util.List;
import java.util.logging.Logger;

public class SavePulsesUseCase {
  private final Logger LOG = Logger.getLogger(SavePulsesUseCase.class.getName());

  public SavePulsesResponse savePulses(SavePulsesRequest request) {
      try {
          List<Pulse> list = new PulseMapper().map(request);
          list.forEach(pulse -> LOG.fine(() -> "RESPONSE::" + pulse.toString()));
          return SavePulsesResponse.processed();
        } catch(RuntimeException error) {
          return SavePulsesResponse.error(error);
        }
  }
}
