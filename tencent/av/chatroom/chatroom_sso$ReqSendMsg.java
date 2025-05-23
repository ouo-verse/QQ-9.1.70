package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$ReqSendMsg extends MessageMicro<chatroom_sso$ReqSendMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"room_key", "msg"}, new Object[]{null, null}, chatroom_sso$ReqSendMsg.class);
    public chatroom_sso$RoomKey room_key = new chatroom_sso$RoomKey();

    /* renamed from: msg, reason: collision with root package name */
    public chatroom_sso$Msg f435894msg = new chatroom_sso$Msg();
}
