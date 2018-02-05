/*
 * Copyright (c) 2018. Nikitin Mikhail. All rights reserved.
 */

package com.nikitin.telegrambot.bots;

import com.nikitin.telegrambot.util.annotations.TelegramBot;
import java.text.MessageFormat;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@TelegramBot
@Slf4j
public class HelloWorldBot extends TelegramLongPollingBot {

  private static final String BOT_USERNAME = "nikitin_hello_world_bot";
  private static final String ACCESS_TOKEN = "445677731:AAGFDpWSOz8hNB7XjUwfu171_BNI2zekRa0";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      SendMessage message = new SendMessage()
          .setChatId(update.getMessage().getChatId())
          .setText(getFormattedUpdateMessage(update));
      try {
        execute(message);
      } catch (TelegramApiException e) {
        log.error("onUpdateReceived", e);
      }
    }
  }

  @Override
  public String getBotUsername() {
    return BOT_USERNAME;
  }

  @Override
  public String getBotToken() {
    return ACCESS_TOKEN;
  }

  private String getFormattedUpdateMessage(Update update) {
    Message message = update.getMessage();
    return MessageFormat.format(
        "User: {0} \n"
            + "ChatId: {1} \n"
            + "Location: {2}\n "
            + "Text: {3}",
        message.getFrom(),
        message.getChatId(),
        message.getLocation(),
        message.getText());
  }
}

