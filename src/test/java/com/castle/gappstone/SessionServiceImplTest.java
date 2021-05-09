package com.castle.gappstone;

import com.castle.gappstone.domain.model.Session;
import com.castle.gappstone.domain.repository.SessionRepository;
import com.castle.gappstone.domain.service.SessionService;
import com.castle.gappstone.service.SessionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SessionServiceImplTest {
    @MockBean
    private SessionRepository sessionRepository;

    @Autowired
    private SessionService sessionService;


    @TestConfiguration
    static class SessionServiceImplTestConfiguration {
        @Bean
        public SessionService sessionService() {
            return new SessionServiceImpl();
        }
    }
    @Test
    @DisplayName("When getVoteByTitle With Valid Title Then Returns Post")
    public void whenGetVoteByTitleWithValidTitleThenReturnsPost() {
        // Arrange
        String date = "Great Date";
        String description = "Great Description";
        String place = "Great Place";
        Long id = 1L;
        Session session = new Session().setId(id).setDate(date).setDescription(description).setPlace(place);
        when(sessionRepository.findById(id))
                .thenReturn(Optional.of(session));

        // Act
        Session foundSession = sessionService.getSessionById(id);

        // Assert
        assertThat(foundSession.getId()).isEqualTo(id);
    }
}
}
