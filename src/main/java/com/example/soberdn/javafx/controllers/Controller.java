package com.example.soberdn.javafx.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Controller {
  private static final Logger logger = LoggerFactory.getLogger(Controller.class);

  void pause() {
    logger.debug("pause: -");
  }

  public void resume() {
    logger.debug("resume: -");
  }

  public void shutdown() {
    logger.debug("shutdown: -");
  }

}
