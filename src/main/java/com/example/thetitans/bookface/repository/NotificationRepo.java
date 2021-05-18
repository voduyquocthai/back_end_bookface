package com.example.thetitans.bookface.repository;

import com.example.thetitans.bookface.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
