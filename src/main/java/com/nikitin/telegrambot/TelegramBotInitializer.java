/*
 * Copyright (c) 2018. Nikitin Mikhail. All rights reserved.
 */

package com.nikitin.telegrambot;

import com.nikitin.telegrambot.bots.HelloWorldBot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * Main initializer of telegram bots
 */
@Component
@AllArgsConstructor
@Slf4j
public class TelegramBotInitializer implements ApplicationRunner {

  private HelloWorldBot helloWorldBot;

  @Override
  public void run(ApplicationArguments applicationArguments) {
    TelegramBotsApi botsApi = new TelegramBotsApi();
    try {
      botsApi.registerBot(helloWorldBot);
    } catch (Exception e) {
      log.error("Unexpected exception caught: ", e);
    }

  }
}
