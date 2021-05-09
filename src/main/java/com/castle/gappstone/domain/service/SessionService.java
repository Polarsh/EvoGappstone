package com.castle.gappstone.domain.service;

import com.castle.gappstone.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SessionService {

    Page<Session> getAllSessions(Pageable pageable);
    Session getSessionById(Long sessionID);
    Session createSession(Session session);
    Session updateSession(Long sessionId, Session session);
    ResponseEntity<?> deleteSession(Long sessionId);

}
