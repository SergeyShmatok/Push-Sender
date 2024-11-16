package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message1 = Message.builder()
        .putData("action_1", "LIKE")
        .putData("content_1", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()


    val message2 = Message.builder()
        .putData("action_2", "NewPost")
        .putData("content_2", """{
           "userId": 2,
           "userName": "Sergey",
           "postContent": "When you start an activity from a notification, you must preserve the user's expected navigation experience. Tapping the Back button must take the user back through the app's normal work flow to the Home screen, and opening the Recents screen must show the activity as a separate task. To preserve this navigation experience, start the activity in a fresh task."
        }""".trimIndent())
        .setToken(token)
        .build()


    val message3 = Message.builder()
        .putData("action", "qwe")
        .putData("content_2", """{
            "userId": 1,
            "userName": "Petr",
            "postId": 2,
            "postAuthor": "Netology"
             }""".trimIndent())
        .setToken(token)
        .build()


    FirebaseMessaging.getInstance().send(message1)

    Thread.sleep(3000)

    FirebaseMessaging.getInstance().send(message2)

    Thread.sleep(3000)

    FirebaseMessaging.getInstance().send(message3)



}

