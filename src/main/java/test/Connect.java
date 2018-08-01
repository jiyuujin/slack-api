package test;

import com.ullink.slack.simpleslackapi.*;
import com.ullink.slack.simpleslackapi.impl.*;
import test.message.Message;

import java.io.IOException;

public class Connect {

    // クラスフィールド
    // BotTokenは定数として扱われるためfinal修飾子を指定
    private static final String botToken = "xoxb-294501866708-398667584307-LyQ7KyVOQ6PiOeqTY4Pi7TYS";

    public static void main(String[] args) throws IOException {
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession(botToken);

        session.connect();

        // Connectインスタンスを作成する
        Connect connect = new Connect();
        // メッセージを送信する
        connect.sendWithSession(session);

        session.disconnect();
    }

    /**
     * メッセージを送信する
     * @param session SlackSessionオブジェクト
     */
    private void sendWithSession(SlackSession session) {
        Message message = new Message();
        message.sendMessage(session);
    }

}
