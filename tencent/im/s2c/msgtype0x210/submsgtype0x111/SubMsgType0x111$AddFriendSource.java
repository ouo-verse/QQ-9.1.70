package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x111$AddFriendSource extends MessageMicro<SubMsgType0x111$AddFriendSource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source", "uint32_sub_source"}, new Object[]{0, 0}, SubMsgType0x111$AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
}
