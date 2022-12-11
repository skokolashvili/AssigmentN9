package com.example.sabakokolashvili2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.sabakokolashvili2.Utils.CHANNEL_Desc
import com.example.sabakokolashvili2.Utils.CHANNEL_ID
import kotlinx.android.synthetic.main.fragment_one2.*


class OneFragment : Fragment(R.layout.fragment_one2) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpUi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpUi() {
        button.setOnClickListener {
//            val builder = NotificationCompat.Builder(requireContext(), Utils.CHANNEL_ID)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Expandable Notification Title").setContentText("Lorem ipsum")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT).setStyle(
//                    NotificationCompat.BigTextStyle()
//                        .bigText("sdfsdfsdf sfd dsfsdfsdf sdfsdf sdfsdfsdf"))
//
//            val notiManagerCompat = NotificationManagerCompat.from(requireContext())
//            notiManagerCompat.notify(Utils.NOTI_ID,builder.build())
            val name = Utils.CHANNEL_NAME
            val descriptionText =CHANNEL_Desc
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(requireActivity(),NotificationManager::class.java) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            // Create an explicit intent for an Activity in your app

            val builder = NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
                .setSmallIcon(com.google.android.material.R.drawable.ic_m3_chip_check)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
            with(NotificationManagerCompat.from(requireActivity())) {
                // notificationId is a unique int for each notification that you must define
                notify(1, builder.build())
            }

            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }
    }
}