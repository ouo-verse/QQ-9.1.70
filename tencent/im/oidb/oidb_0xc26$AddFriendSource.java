package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$AddFriendSource extends MessageMicro<oidb_0xc26$AddFriendSource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source", "uint32_sub_source"}, new Object[]{0, 0}, oidb_0xc26$AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
}
