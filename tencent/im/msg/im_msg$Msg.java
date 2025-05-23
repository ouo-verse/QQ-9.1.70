package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$Msg extends MessageMicro<im_msg$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "body"}, new Object[]{null, null}, im_msg$Msg.class);
    public im_msg$MsgHead head = new im_msg$MsgHead();
    public im_msg_body$MsgBody body = new im_msg_body$MsgBody();
}
