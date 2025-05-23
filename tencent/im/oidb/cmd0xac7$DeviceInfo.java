package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac7$DeviceInfo extends MessageMicro<cmd0xac7$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_din", "bytes_name"}, new Object[]{0L, ByteStringMicro.EMPTY}, cmd0xac7$DeviceInfo.class);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
