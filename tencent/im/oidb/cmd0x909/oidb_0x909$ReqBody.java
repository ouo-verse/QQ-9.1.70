package tencent.im.oidb.cmd0x909;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x909$ReqBody extends MessageMicro<oidb_0x909$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_to", "uint64_labelid", "uint64_photoid", "uint32_photo_slot", "int32_count"}, new Object[]{0L, 0L, 0L, 0, 0}, oidb_0x909$ReqBody.class);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt64Field uint64_labelid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_photoid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_photo_slot = PBField.initUInt32(0);
    public final PBInt32Field int32_count = PBField.initInt32(0);
}
