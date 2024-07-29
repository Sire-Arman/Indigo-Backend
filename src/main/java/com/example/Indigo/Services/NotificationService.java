package com.example.Indigo.Services;

import com.example.Indigo.Models.Notification;
import com.example.Indigo.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
  public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}
