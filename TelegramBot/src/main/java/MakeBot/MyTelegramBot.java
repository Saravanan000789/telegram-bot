package MakeBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        // Assuming you get chatId from the update
        long chatId = update.getMessage().getChatId();

        SendMessage message = new SendMessage();
        // Convert long chatId to String
        message.setChatId(String.valueOf(chatId));
        message.setText("Hello, this is your bot speaking!");

        try {
            execute(message); // Send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@adayar_bot";
    }

    @Override
    public String getBotToken() {
        return "7191876143:AAHBDW18Mzn0NfPR0e9MjJHc_fJIZoga3DM";
    }
}
