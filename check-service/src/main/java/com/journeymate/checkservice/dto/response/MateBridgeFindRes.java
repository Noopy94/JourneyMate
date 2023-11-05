package com.journeymate.checkservice.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateBridgeFindRes {

    private String message;

    private MateBridgeFindData data;

    @Data
    public static class MateBridgeFindData {

        List<UserFindRes> users;

        String creator;

    }

    @Data
    public class UserFindRes {

        private String id;

        private String nickname;

        private String imgUrl;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

    }
}
