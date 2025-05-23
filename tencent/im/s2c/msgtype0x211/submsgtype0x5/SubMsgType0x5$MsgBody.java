package tencent.im.s2c.msgtype0x211.submsgtype0x5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x5$MsgBody extends MessageMicro<SubMsgType0x5$MsgBody> {
    public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_sessionid"}, new Object[]{0}, SubMsgType0x5$MsgBody.class);
    public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
}
