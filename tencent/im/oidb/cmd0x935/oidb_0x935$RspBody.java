package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x935$RspBody extends MessageMicro<oidb_0x935$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"recommend_info", "is_end", "cur_pos"}, new Object[]{null, 0, 0}, oidb_0x935$RspBody.class);
    public final PBRepeatMessageField<oidb_0x935$RecommendInfo> recommend_info = PBField.initRepeatMessage(oidb_0x935$RecommendInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field cur_pos = PBField.initUInt32(0);
}
