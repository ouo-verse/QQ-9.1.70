package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc9$RspBody extends MessageMicro<oidb_0xdc9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"honor_list", "cache_ts", "honor_info"}, new Object[]{null, 0, null}, oidb_0xdc9$RspBody.class);
    public final PBRepeatMessageField<oidb_0xdc9$HonorList> honor_list = PBField.initRepeatMessage(oidb_0xdc9$HonorList.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xdc9$HonorInfo> honor_info = PBField.initRepeatMessage(oidb_0xdc9$HonorInfo.class);
}
