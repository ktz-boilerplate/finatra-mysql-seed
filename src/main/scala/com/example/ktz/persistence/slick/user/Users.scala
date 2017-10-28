package com.example.ktz.persistence.slick.user

import org.joda.time.DateTime

case class Users(
  id:        Long,
  name:      String,
  createdAt: DateTime
)
