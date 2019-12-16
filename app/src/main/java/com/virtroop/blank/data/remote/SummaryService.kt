package com.virtroop.blank.data.remote

import com.virtroop.blank.data.model.Summary
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface SummaryService {

  @GET("getSummaries")
  fun getSummaries(): Single<Response<Summary>>

}

