package com.abdullah996.fullstacktodoapp.helloWord

data class HelloWorldBean(var message: String) {
    override fun toString(): String {
        return "HelloWorldBean [message=$message]"
    }
}