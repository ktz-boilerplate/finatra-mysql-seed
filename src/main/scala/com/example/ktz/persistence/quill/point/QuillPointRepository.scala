package com.example.ktz.persistence.quill.point

import javax.inject.{ Inject, Singleton }

import com.example.ktz.core.quill.QuillExtensions
import com.example.ktz.modules.QuillDatabaseModule._
import com.twitter.util.Future
import io.getquill._

@Singleton
class QuillPointRepository @Inject() (val ctx: QuillDatabaseSource) extends QuillExtensions {

  import ctx._

  def findByUserId(userId: Int): Future[Option[Points]] = {
    val q = quote { (userId: Int) =>
      query[Points].filter(p => p.userId == userId).take(1)
    }
    ctx.run(q(lift(userId))).map(_.headOption)
  }

}
