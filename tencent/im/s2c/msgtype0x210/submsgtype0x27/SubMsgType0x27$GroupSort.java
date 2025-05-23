package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$GroupSort extends MessageMicro<SubMsgType0x27$GroupSort> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_groupid", "uint32_sortid"}, new Object[]{0, 0}, SubMsgType0x27$GroupSort.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
}
