package tencent.im.oidb.cmd0x69e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x69e$ReqBody extends MessageMicro<oidb_cmd0x69e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint32_channel_ids"}, new Object[]{0}, oidb_cmd0x69e$ReqBody.class);
    public final PBRepeatField<Integer> rpt_uint32_channel_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
