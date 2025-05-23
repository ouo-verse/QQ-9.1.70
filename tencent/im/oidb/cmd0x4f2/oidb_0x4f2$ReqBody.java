package tencent.im.oidb.cmd0x4f2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4f2$ReqBody extends MessageMicro<oidb_0x4f2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_appid_list"}, new Object[]{0L}, oidb_0x4f2$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_appid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
