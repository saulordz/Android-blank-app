package com.vitroop.blank.common

import com.virtroop.blank.rx.SchedulerComposer
import com.virtroop.blank.rx.SchedulerProvider
import io.reactivex.schedulers.Schedulers

object TestUtils {

  internal val schedulerComposer = SchedulerComposer(object : SchedulerProvider {
    override val computation = Schedulers.trampoline()
    override val io = Schedulers.trampoline()
    override val ui = Schedulers.trampoline()
  })

}
