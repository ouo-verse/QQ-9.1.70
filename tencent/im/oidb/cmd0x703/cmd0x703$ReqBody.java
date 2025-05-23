package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x703$ReqBody extends MessageMicro<cmd0x703$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 480008}, new String[]{"rpt_uint64_uin", "uint32_photo_type", "uint32_include_invalid"}, new Object[]{0L, 0, 0}, cmd0x703$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_photo_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_include_invalid = PBField.initUInt32(0);
}
