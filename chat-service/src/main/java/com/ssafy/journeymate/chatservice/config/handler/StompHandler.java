package com.ssafy.journeymate.chatservice.config.handler;
// import ... 생략

import com.ssafy.journeymate.chatservice.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class StompHandler implements ChannelInterceptor {

    private final ChatService chatService;

    // websocket을 통해 들어온 요청이 처리 되기전 실행된다.
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//        if (StompCommand.CONNECT == accessor.getCommand()) { // websocket 연결요청
//
//        } else if (StompCommand.SUBSCRIBE == accessor.getCommand()) { // 채팅룸 구독요청
//            // header정보에서 구독 destination정보를 얻고, mateId를 추출한다.
//            long mateId = commentService.getMateId(Optional.ofNullable((String) message.getHeaders().get("simpDestination")).orElse("InvalidMateId"));
//            // 채팅방에 들어온 클라이언트 sessionId를 mateId와 맵핑해 놓는다.(나중에 특정 세션이 어떤 채팅방에 들어가 있는지 알기 위함)
//            String sessionId = (String) message.getHeaders().get("simpSessionId");
//            // 클라이언트 입장 메시지를 채팅방에 발송한다.(redis publish)
//            String name = Optional.ofNullable((Principal) message.getHeaders().get("simpUser")).map(Principal::getName).orElse("UnknownUser");
//            commentService.sendComment(
//                Comment.builder().type(Comment.CommentType.ENTER).mateId(mateId).sender(name).build());
//            log.info("SUBSCRIBED {}, {}", name, mateId);
//        } else if (StompCommand.DISCONNECT == accessor.getCommand()) { // Websocket 연결 종료
//            // 연결이 종료된 클라이언트 sesssionId로 채팅방 id를 얻는다.
//            String sessionId = (String) message.getHeaders().get("simpSessionId");
//            long mateId = mateRepository.getUserEnterMateId(sessionId);
//            // 채팅방의 인원수를 -1한다.
//            mateRepository.minusUserCount(mateId);
//            // 클라이언트 퇴장 메시지를 채팅방에 발송한다.(redis publish)
//            String name = Optional.ofNullable((Principal) message.getHeaders().get("simpUser")).map(Principal::getName).orElse("UnknownUser");
//            commentService.sendComment(
//                Comment.builder().type(Comment.CommentType.QUIT).mateId(mateId).sender(name).build());
//            // 퇴장한 클라이언트의 mateId 맵핑 정보를 삭제한다.
//            mateRepository.removeUserEnterInfo(sessionId);
//            log.info("DISCONNECTED {}, {}", sessionId, mateId);
//        }
        return message;
    }
}