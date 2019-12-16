package com.virtroop.blank.ui.catalog

import com.virtroop.blank.base.BaseDisposablePresenter
import com.virtroop.blank.data.repository.SummaryRepository
import com.virtroop.blank.rx.SchedulerComposer
import javax.inject.Inject

class CatalogPresenter @Inject constructor(
  schedulerComposer: SchedulerComposer,
  private val summaryRepository: SummaryRepository
) : BaseDisposablePresenter<CatalogContract.View>(schedulerComposer), CatalogContract.Presenter {

  override fun calculateHello() = addDisposable {
    summaryRepository.singleGetSummaries()
      .compose(schedulerComposer.singleIoUiComposer())
      .subscribe({ helloCalculated(it.bookName.orEmpty()) }) { throw IllegalStateException("Error later") }
  }

  private fun helloCalculated(result: String) = ifViewAttached {
    it.sayHello(result)
  }

}
