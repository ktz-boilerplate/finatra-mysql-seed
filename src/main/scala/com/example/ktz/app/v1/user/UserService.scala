package com.example.ktz.app.v1.user

import javax.inject.Inject

import com.example.ktz.persistence.quill.user.QuillUserRepository
import com.example.ktz.persistence.slick.user.SlickUserRepository
import com.twitter.util.Future
import com.github.ikhoon.TwitterFutureOps._
import scala.concurrent.ExecutionContext.Implicits.global

class UserService @Inject() (
  quillUserRepository: QuillUserRepository,
  slickUserRepository: SlickUserRepository
) {

  def findByIdWithQuill(id: Int): Future[Option[UserDto]] = {
    quillUserRepository.findById(id).map(_.map(user => UserDto(user.id, user.name)))
  }

  def findByIdWithSlick(id: Long): Future[Option[UserDto]] = {
    slickUserRepository.findById(id).map(_.map(user => UserDto(user.id.toInt, user.name))).toTwitterFuture
  }

}
