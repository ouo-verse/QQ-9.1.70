package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$RspSendMsg extends MessageMicro<chatroom_sso$RspSendMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"result", "err_msg", "msg_id"}, new Object[]{0, "", 0}, chatroom_sso$RspSendMsg.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field msg_id = PBField.initUInt32(0);
}
