/*
 * Copyright (c) 2018. Nikitin Mikhail. All rights reserved.
 */

package com.nikitin.telegrambot.config;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;

@Component
public class TelegramInitializerConfig {

  @PostConstruct
  private void initApiContextInitializer() {
    ApiContextInitializer.init();
  }
}
