package com.github.alextremp.pulse.application.savepulses;

import com.github.alextremp.pulse.application.savepulses.io.PulseEvent;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesResponse;
import java.util.HashMap;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SavePulsesUseCaseTest {
  private static final String AN_ID = "anId";
  private static final String A_NAME = "A_NAME";

  @Test
  public void shouldReturnAProcessedWhenCorrectRequest() {
    SavePulsesRequest request = new SavePulsesRequest();
    request.setId(AN_ID);
    request.setEvents(createListEvent());
    SavePulsesResponse savePulseResponse = new SavePulsesUseCase().savePulses(request);
    assertThat(savePulseResponse.getCode(), is(SavePulsesResponse.PROCESSED));
  }

  @Test
  public void shouldReturnAErrorWhenIncorrectRequest() {
    SavePulsesRequest request = new SavePulsesRequest();
    request.setEvents(createListEvent());
    SavePulsesResponse savePulseResponse = new SavePulsesUseCase().savePulses(request);
    assertThat(savePulseResponse.getCode(), is(SavePulsesResponse.ERROR));
  }



  private PulseEvent[] createListEvent() {

    PulseEvent[] list =  new PulseEvent[1];
    PulseEvent aPulseEvent = new PulseEvent();
    aPulseEvent.setName(A_NAME);
    aPulseEvent.setPayload(new HashMap<>());
    list[0] = aPulseEvent;
    return list;
  }
}