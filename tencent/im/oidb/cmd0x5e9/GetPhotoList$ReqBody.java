package tencent.im.oidb.cmd0x5e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class GetPhotoList$ReqBody extends MessageMicro<GetPhotoList$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"rpt_uint64_uin", "uint32_fetch_type"}, new Object[]{0L, 0}, GetPhotoList$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_fetch_type = PBField.initUInt32(0);
}
