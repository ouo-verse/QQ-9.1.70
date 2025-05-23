package tencent.im.s2c.msgtype0x210.submsgtype0x11f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x11f$MediaUserInfo extends MessageMicro<SubMsgType0x11f$MediaUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_to_uin", "uint32_join_state"}, new Object[]{0L, 0}, SubMsgType0x11f$MediaUserInfo.class);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_join_state = PBField.initUInt32(0);
}
