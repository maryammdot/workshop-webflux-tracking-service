package com.github.alextremp.pulse.application.savepulses.io;

import com.github.alextremp.pulse.domain.pulse.Pulse;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PulseMapperTest {
  private static final String A_NAME = "A_NAME";
  private static final String AN_ID = "anId";
  private static int EXPECTED_SIZE = 0;

  @Test
  public void shouldReturnEmptyListWhenNoEventPulseEvent() {

    SavePulsesRequest request = new SavePulsesRequest();
    request.setId(AN_ID);
    PulseMapper mapper = new PulseMapper();
    List<Pulse> list = mapper.map(request);
    assertThat(list.size(), is(EXPECTED_SIZE));
  }

  @Test
  public void shouldReturnListWithOnePulseWhenNoEventPulseEvent() {

    SavePulsesRequest request = new SavePulsesRequest();
    request.setId(AN_ID);
    request.setEvents(createListEvent());
    PulseMapper mapper = new PulseMapper();
    List<Pulse> list = mapper.map(request);
    assertThat(list.size(), is(1));
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