package com.portfolio.jgsilveira.cesar.linkedlists.mailprocessor;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.portfolio.jgsilveira.cesar.linkedlists.duplicatedmails.DuplicateMailsHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailProcessorService extends Service {

    private static final String MAIL_PROCESSOR_FINISHED_TAG = "mailProcessorFinished";

    private static final String RESPONSE_KEY = "response";
    public static final String MAIL_KEY = "mail";

    private ExecutorService mExecutor;

    private Messenger mMessenger = new Messenger(new MailIncomingHandler());

    @Override
    public void onCreate() {
        super.onCreate();
        mExecutor = Executors.newSingleThreadExecutor();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private void sendResponse(String response) {
        Bundle args = new Bundle();
        args.putString(RESPONSE_KEY, response);
        Intent intent = new Intent(MAIL_PROCESSOR_FINISHED_TAG);
        intent.putExtras(args);
        sendBroadcast(intent);
    }

    private class RemoveDuplicatedTask implements Runnable {

        private Node mNode;

        RemoveDuplicatedTask(Node node) {
            mNode = node;
        }

        @Override
        public void run() {
            DuplicateMailsHelper.removeDuplicatedOnes(mNode);
            String json = new Gson().toJson(mNode);
            sendResponse(json);
        }

    }

    @SuppressLint("HandlerLeak")
    private class MailIncomingHandler extends Handler {

        @Override
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            String jsonMail = data.getString(MAIL_KEY);
            Node mailNode = new Gson().fromJson(jsonMail, Node.class);
            mExecutor.submit(new RemoveDuplicatedTask(mailNode));
        }

    }

}
