/*
 * Copyright (c) 2018. Nikitin Mikhail. All rights reserved.
 */

package com.nikitin.telegrambot.util.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * {@link Component} that is responsible for Telegram bot creations
 */
@Component
@DependsOn("telegramInitializerConfig")
@Retention(RetentionPolicy.RUNTIME)
public @interface TelegramBot {

}
