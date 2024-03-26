package ashes.websocket.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "chats")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    String id;

    @Column(columnDefinition = "text")
    String content;

    @Column(name = "sender_id")
    String senderId;

    @Column(name = "receiver_id")
    String receiverId;

    @Column(name = "created_date")
    Long createdDate = new Date().getTime();

    @ManyToOne
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    User receiver;
}
