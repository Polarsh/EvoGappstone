package com.castle.gappstone.service;

import com.castle.gappstone.domain.model.Session;
import com.castle.gappstone.domain.repository.SessionRepository;
import com.castle.gappstone.domain.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.castle.gappstone.exception.ResourceNotFoundException;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public SessionServiceImpl() {
    }

    public Page<Session> getAllSessions(Pageable pageable) {
        return this.sessionRepository.findAll(pageable);
    }

    public Session getSessionById(Long sessionId) {
        return (Session) this.sessionRepository.findById(sessionId).orElseThrow(() -> {
            return new ResourceNotFoundException("Session", "Id", sessionId);
        });
    }

    public Session createSession(Session session) { return (Session) this.sessionRepository.save(session);    }

    public Session updateSession(Long sessionId, Session sessionRequest) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session", "Id", sessionId));
        return sessionRepository.save(
                session.setDate(sessionRequest.getDate())
                        .setDescription(sessionRequest.getDescription())
                        .setPlace(sessionRequest.getPlace()));
    }

    public ResponseEntity<?> deleteSession(Long sessionId) {
        return (ResponseEntity)this.sessionRepository.findById(sessionId).map((session) -> {
            this.sessionRepository.delete(session);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> {
            return new ResourceNotFoundException("Session", "Id", sessionId);
        });
    }
}
