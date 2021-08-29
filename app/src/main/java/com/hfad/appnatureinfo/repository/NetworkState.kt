package com.hfad.appnatureinfo.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {
companion object {
    var LOADED: NetworkState = NetworkState(Status.SUCCESS, "Success")
    var LOADING: NetworkState = NetworkState(Status.RUNNING, "Running")
    var ERROR: NetworkState =  NetworkState(Status.FAILED, "Something went wrong")
}

}