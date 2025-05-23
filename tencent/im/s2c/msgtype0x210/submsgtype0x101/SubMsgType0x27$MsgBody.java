package tencent.im.s2c.msgtype0x210.submsgtype0x101;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$MsgBody extends MessageMicro<SubMsgType0x27$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_push_platform", "msg_client_report"}, new Object[]{null, null}, SubMsgType0x27$MsgBody.class);
    public SubMsgType0x27$PushPlatform msg_push_platform = new SubMsgType0x27$PushPlatform();
    public SubMsgType0x27$ClientReport msg_client_report = new SubMsgType0x27$ClientReport();
}
