package ashes.websocket.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatReq {

    @NotBlank(message = "sender is requried")
    String sender;

    @NotBlank(message = "receiver is requried")
    String receiver;

    @NotBlank(message = "content is requried")
    String content;
}
