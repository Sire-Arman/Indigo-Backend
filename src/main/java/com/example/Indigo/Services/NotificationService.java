//package com.example.Indigo.Services;
//
//import com.google.firebase.messaging.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//    @Autowired
//    private FirebaseMessaging firebaseMessaging;
//
//    public void sendPushNotification(String token, String title, String body) {
//        Message message = Message.builder()
//                .setToken(token)
//                .setAndroidConfig(AndroidConfig.builder()
//                        .setNotification(AndroidNotification.builder()
//                                .setTitle(title)
//                                .setBody(body)
//                                .build())
//                        .build())
//                .setApnsConfig(ApnsConfig.builder()
//                        .setAps(Aps.builder()
//                                .setAlert(ApsAlert.builder()
//                                        .setTitle(title)
//                                        .setBody(body)
//                                        .build())
//                                .build())
//                        .build())
//                .build();
//
//        try {
//            String response = firebaseMessaging.send(message);
//            System.out.println("Successfully sent message: " + response);
//        } catch (FirebaseMessagingException e) {
//            System.out.println("Failed to send message: " + e.getMessage());
//        }
//    }
//
//    public void sendEmailNotification(String email, String subject, String body) {
//        // Implement email sending logic
//    }
//
//    public void sendSmsNotification(String phoneNumber, String message) {
//        // Implement SMS sending logic
//    }
//}