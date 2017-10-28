package com.example.ktz.app.v1.user

import javax.inject.Inject

import com.example.ktz.swagger.SimpleSwaggerController
import com.twitter.finagle.http.Request
import io.swagger.models.Swagger

class UserController @Inject() (
  userService:      UserService,
  userPointService: UserPointService,
  s:                Swagger
) extends SimpleSwaggerController {

  {
    import com.example.ktz.swagger.SwaggerDocument.FindUserByIdWithQuillDocument
    Get("/users/:id/quill") { request: Request =>
      userService.findByIdWithQuill(request.getIntParam("id"))
    }
  }

  {
    import com.example.ktz.swagger.SwaggerDocument.FindUserByIdWithSlickDocument
    Get("/users/:id/slick") { request: Request =>
      userService.findByIdWithSlick(request.getLongParam("id"))
    }
  }

  {
    import com.example.ktz.swagger.SwaggerDocument.GetUserPointByEmailDocument
    Get("/users/:email/point") { request: Request =>
      userPointService.getPointByUserEmail(request.getParam("email"))
    }
  }
}
