package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$FrdCustomOnlineStatusChange extends MessageMicro<SubMsgType0x27$FrdCustomOnlineStatusChange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, SubMsgType0x27$FrdCustomOnlineStatusChange.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
