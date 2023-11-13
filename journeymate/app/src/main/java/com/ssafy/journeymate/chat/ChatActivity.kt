import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.bishoybasily.stomp.lib.*
import com.gmail.bishoybasily.stomp.lib.Event.Type.*
import com.gmail.bishoybasily.stomp.lib.StompClient
import com.gmail.bishoybasily.stomp.lib.constants.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ssafy.journeymate.R
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.dto.LifecycleEvent

class ChatActivity : AppCompatActivity() {


    private var mateId: Long = 1 // 예시 채팅방 ID
    private var userId: String = "user_id" // 예시 사용자 ID


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    lateinit var stompConnection: Disposable
    lateinit var topic: Disposable




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

//        val url = "ws://example.com/endpoint"
//        val intervalMillis = 1000L
//        val client = OkHttpClient()
//
//        val stomp = StompClient(url, intervalMillis, client)
//
//// connect
//        stompConnection = stomp.connect().subscribe {
//            when (it.type) {
//                OPENED -> {
//
//                }
//                CLOSED -> {
//
//                }
//                ERROR -> {
//
//                }
//
//            }
//        }
//        var mateId = 8;
//        // subscribe
//        topic = stomp.subscribe("/sub/chat-service/mate"+mateId).subscribe { Log.i(TAG, it) }
//
//// unsubscribe
//        topic.dispose()
//
//// send
//        stomp.send("/destination", "dummy message").subscribe {
//            if (it) {
//            }
//        }
//
//// disconnect
//        stompConnection.dispose()
//        topic = stomp.join("/destination").subscribe { it ->
//            val responseData = JSONObject(it).getString("message")
//
//            val modelList = Gson().fromJson<ArrayList<ColorSpace.Model>>(
//                responseData, TypeToken.getParameterized(
//                    MutableList::class.java,
//                    ColorSpace.Model::class.java
//                ).type)
//        }


        recyclerView = findViewById(R.id.messageActivity_recyclerview)
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        initializeWebSocketConnection()
        fetchChatRoomDetails()
    }

    private fun initializeWebSocketConnection() {
//        stompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, "ws://your_backend_endpoint/ws-stomp")
//        stompClient.connect()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                subscribeToChatRoom()
//            }, {
//                // 연결 실패 처리
//            })
    }
//
//    private fun subscribeToChatRoom() {
//        stompClient.topic("/sub/chatroom/$mateId")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ message: StompMessage ->
//                val chatMessage = convertJsonToChatMessage(message.payload)
//                runOnUiThread {
//                    adapter.addMessage(chatMessage)
//                }
//            }, {
//                // 메시지 수신 에러 처리
//            })
//    }
//
//    private fun sendMessage(message: String) {
//        val chatMessage = ChatMessage(userId, mateId, message)
//        stompClient.send("/pub/chatroom/$mateId", chatMessage.toJson())
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                // 메시지 전송 성공 처리
//            }, {
//                // 메시지 전송 실패 처리
//            })
//    }

    private fun fetchChatRoomDetails() {
        // Retrofit을 사용하여 채팅방 관련 데이터 가져오기
        // 예: 채팅방 메시지 목록, 참여자 정보 등
    }

//    private fun convertJsonToChatMessage(json: String): ChatMessage {
//        // JSON 문자열을 ChatMessage 객체로 변환하는 로직
//    }

    data class ChatMessage(val userId: String, val mateId: Long, val message: String) {
//        fun toJson(): String {
//            // 객체를 JSON 문자열로 변환하는 로직
//        }
    }

    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MessageViewHolder>() {
        private val messages = ArrayList<ChatMessage>()

        fun addMessage(message: ChatMessage) {
            messages.add(message)
            notifyDataSetChanged()
            recyclerView.scrollToPosition(messages.size - 1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
            return MessageViewHolder(view)
        }

        override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
            val message = messages[position]
            holder.textView_message.text = message.message
            // 추가적인 UI 설정...
        }

        override fun getItemCount(): Int = messages.size

        inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView_message: TextView = view.findViewById(R.id.messageItem_textView_message)
            // 기타 필요한 뷰 요소들...
        }
    }
}