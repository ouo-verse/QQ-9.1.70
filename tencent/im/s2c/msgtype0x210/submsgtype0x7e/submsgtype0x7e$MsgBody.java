package tencent.im.s2c.msgtype0x210.submsgtype0x7e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x7e$MsgBody extends MessageMicro<submsgtype0x7e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_notice", "msg_online_push"}, new Object[]{"", null}, submsgtype0x7e$MsgBody.class);
    public final PBStringField str_notice = PBField.initString("");
    public submsgtype0x7e$WalletMsgPush msg_online_push = new submsgtype0x7e$WalletMsgPush();
}
