package tencent.im.oidb.cmd0xded;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xded$RspBody extends MessageMicro<oidb_0xded$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_classify_info"}, new Object[]{null}, oidb_0xded$RspBody.class);
    public final PBRepeatMessageField<oidb_0xded$ClassifyInfo> rpt_classify_info = PBField.initRepeatMessage(oidb_0xded$ClassifyInfo.class);
}
