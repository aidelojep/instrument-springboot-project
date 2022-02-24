import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.http4k.client.WebsocketClient
import org.http4k.core.Uri
import org.http4k.websocket.Websocket

class InstrumentStream(
  uriString: String = "ws://localhost:8032/instruments",
) {

  private val uri = Uri.of(uriString)

  private lateinit var ws: Websocket

  fun connect(onEvent: (InstrumentEvent) -> Unit) {
    ws = WebsocketClient.nonBlocking(uri) { println("Connected instrument stream")}

    ws.onMessage {
      val event = jackson.readValue<InstrumentEvent>(it.body.stream)
      onEvent(event)
    }

    ws.onClose {
      println("Disconnected instrument stream: ${it.code}; ${it.description}")
      runBlocking {
        launch {
          delay(5000L)
          println("Attempting reconnect for instrument stream")
          connect(onEvent)
        }
      }
    }

    ws.onError {
      println("Exception in instrument stream: $it")
    }
  }
}


class QuoteStream(
  uriString: String = "ws://localhost:8032/quotes",
) {

  private val wsURI = Uri.of(uriString)

  private lateinit var ws: Websocket

  fun connect(onEvent: (QuoteEvent) -> Unit) {
    ws = WebsocketClient.nonBlocking(wsURI) { println("Connected quote stream") }

    ws.onMessage {
      val event = jackson.readValue<QuoteEvent>(it.body.stream)
      onEvent(event)
    }

    ws.onClose {
      println("Disconnected quote stream: ${it.code}; ${it.description}")
      runBlocking {
        launch {
          delay(5000L)
          println("Attempting reconnect for quote stream")
          connect(onEvent)
        }
      }
    }

    ws.onError {
      println("Exception in quote stream: $it")
    }
  }
}
