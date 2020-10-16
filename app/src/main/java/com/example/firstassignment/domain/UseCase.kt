package com.example.firstassignment.domain



abstract class UseCase <T> {

    abstract fun execute(): T

}