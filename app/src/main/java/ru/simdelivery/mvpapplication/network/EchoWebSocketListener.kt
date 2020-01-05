package ru.simdelivery.mvpapplication.network

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString


class EchoWebSocketListener: WebSocketListener() {

    companion object {
        private const val NORMAL_CLOSURE_STATUS = 1000
    }

    override fun onOpen(webSocket: WebSocket, response: Response?) {
        webSocket.send("Здарова, здарова, it's Android application")
        //webSocket.send(ByteString.decodeHex("deadbeef"))
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        output("Receiving : $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        output("Receiving bytes : " + bytes.hex())
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        output("Closing : $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable, response: Response?) {
        output("Error : " + t.message)
    }

    fun output(message: String) {
        Log.d("WEBSOCKET_MESSAGES", message)
    }
}