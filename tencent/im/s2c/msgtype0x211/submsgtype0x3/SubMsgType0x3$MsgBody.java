package tencent.im.s2c.msgtype0x211.submsgtype0x3;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x3$MsgBody extends MessageMicro<SubMsgType0x3$MsgBody> {
    public static final int MSG_FAIL_NOTIFY_FIELD_NUMBER = 2;
    public static final int MSG_PROGRESS_NOTIFY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_progress_notify", "msg_fail_notify"}, new Object[]{null, null}, SubMsgType0x3$MsgBody.class);
    public SubMsgType0x3$ProgressNotify msg_progress_notify = new SubMsgType0x3$ProgressNotify();
    public SubMsgType0x3$FailNotify msg_fail_notify = new SubMsgType0x3$FailNotify();
}
