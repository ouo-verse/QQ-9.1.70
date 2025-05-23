package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$FriendInfo extends MessageMicro<oidb_0xcf4$FriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_add_frd_days", "uint32_add_frd_source", "uint32_add_frd_sub_source", "bytes_add_frd_wording"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY}, oidb_0xcf4$FriendInfo.class);
    public final PBUInt32Field uint32_add_frd_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_add_frd_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_add_frd_sub_source = PBField.initUInt32(0);
    public final PBBytesField bytes_add_frd_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
