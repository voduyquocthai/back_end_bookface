package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.token.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
}
