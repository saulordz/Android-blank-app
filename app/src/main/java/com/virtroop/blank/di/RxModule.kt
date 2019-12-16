package com.virtroop.blank.di

import com.virtroop.blank.rx.ApplicationSchedulerProvider
import com.virtroop.blank.rx.SchedulerProvider
import toothpick.config.Module

class RxModule : Module() {
  init {
    bind(SchedulerProvider::class.java).to(ApplicationSchedulerProvider::class.java)
  }
}
