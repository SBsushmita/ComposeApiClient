package com.example.composeapiclient.data.mapper

import com.example.composeapiclient.data.dto.UserDto
import com.example.composeapiclient.domain.model.User


fun UserDto.toUser(): User {
    return User(
        id = id,
        name = title,
        username = description,
        email = image
    )
}
