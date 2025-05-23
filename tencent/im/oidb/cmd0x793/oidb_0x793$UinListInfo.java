package tencent.im.oidb.cmd0x793;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x793$UinListInfo extends MessageMicro<oidb_0x793$UinListInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_uin", "uint64_time", "uint32_type", "feedsid"}, new Object[]{0L, 0L, 0, ByteStringMicro.EMPTY}, oidb_0x793$UinListInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
}
