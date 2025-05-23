package tencent.im.oidb.cmd0x798;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x798$ReqBody extends MessageMicro<oidb_0x798$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"feedsid", "uint64_time", "uint64_uin", "uint32_type"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L, 0}, oidb_0x798$ReqBody.class);
    public final PBBytesField feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> uint32_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
