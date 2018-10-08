package com.example.bcs.minersinctask;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Fragment extends Fragment {

    int count=0;
    TextView txtCount;
    Button buttonInc, buttonDec;


    public Tab4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab4, container, false);

//        NotificationManager notification = (NotificationManager) getActivity().getSystemService( getActivity().NOTIFICATION_SERVICE );
        txtCount =(TextView)view.findViewById(R.id.txtCount);
        buttonInc= (Button) view.findViewById(R.id.btn_add);
        buttonDec= (Button) view.findViewById(R.id.btn_minus);

        sendNotification(view);

        buttonInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtCount.setText(String.valueOf(count));

            }
        });

//        System.out.println("Main Activity count : "+MainActivity.count);
//        if(MainActivity.count.equals(null)){
//            count++;
//        }
        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count < 0){
                    count = 0;
                }
                txtCount.setText(String.valueOf(count));

            }
        });
        return view;
    }

    public void sendNotification(View view) {

        //Get an instance of NotificationManager//

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.add)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");


        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager =

                (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        // When you issue multiple notifications about the same type of event,
        // it’s best practice for your app to try to update an existing notification
        // with this new information, rather than immediately creating a new notification.
        // If you want to update this notification at a later date, you need to assign it an ID.
        // You can then use this ID whenever you issue a subsequent notification.
        // If the previous notification is still visible, the system will update this existing notification,
        // rather than create a new one. In this example, the notification’s ID is 001//

//        NotificationManager.notify().

                mNotificationManager.notify(001, mBuilder.build());
    }

}
