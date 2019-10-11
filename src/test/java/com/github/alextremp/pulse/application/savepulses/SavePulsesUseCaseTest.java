package com.github.alextremp.pulse.application.savepulses;

import com.github.alextremp.pulse.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.pulse.application.savepulses.io.SavePulsesResponse;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SavePulsesUseCaseTest {
@Test
    public void whenNoErrorShoulReturnSavePulsesResponse(){
        SavePulsesRequest testRequest = new SavePulsesRequest();
        testRequest.setId("id");
        SavePulsesResponse response = new SavePulsesUseCase().savePulses(testRequest).block();

        assertThat(response, notNullValue());
    }

@Test
    public void whenErrorShouldReturnSavePulseResponseError() {
    SavePulsesRequest testRequest = new SavePulsesRequest();
    testRequest.setId("id");
    Mono<SavePulsesResponse> response = new SavePulsesUseCase().savePulses(testRequest);
    StepVerifier.create(response)
            .expectNextMatches(response2 -> response2.getCode().equals("ERROR"))
            .verifyComplete();
}
}