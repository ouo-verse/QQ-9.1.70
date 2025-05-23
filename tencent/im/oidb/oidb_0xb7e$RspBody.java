package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb7e$RspBody extends MessageMicro<oidb_0xb7e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_top_item"}, new Object[]{null}, oidb_0xb7e$RspBody.class);
    public final PBRepeatMessageField<oidb_0xb7e$DiandianTopConfig> rpt_top_item = PBField.initRepeatMessage(oidb_0xb7e$DiandianTopConfig.class);
}
