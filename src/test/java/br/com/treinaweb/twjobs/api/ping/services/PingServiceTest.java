package br.com.treinaweb.twjobs.api.ping.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class PingServiceTest {
    @Test
    @Tags({@Tag("service"), @Tag("fast")})
    void ping_shouldReturnMessagePong_wheCalled() {
        //arrange
        var pingService = new PingService();
        //act
        var actual = pingService.ping();
        //assert
        assertNotNull(actual);
        assertNotNull(actual.get("message"));
        assertEquals("pong", actual.get("message"));

    }
}
