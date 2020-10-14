package com.example.firstassignment.domain

import dagger.Component


@Component
interface PostUsecaseComponent {

    fun getPostUsecase() : PostUsecase
}