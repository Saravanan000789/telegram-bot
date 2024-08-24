package MakeBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            // Use the correct constructor for TelegramBotsApi in newer versions
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            
            // Register your bot here
            botsApi.registerBot(new MyTelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
 