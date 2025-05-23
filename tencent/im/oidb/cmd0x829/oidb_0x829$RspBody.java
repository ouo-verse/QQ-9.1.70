package tencent.im.oidb.cmd0x829;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x829$RspBody extends MessageMicro<oidb_0x829$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_add_frd_info"}, new Object[]{null}, oidb_0x829$RspBody.class);
    public final PBRepeatMessageField<oidb_0x829$AddFrdInfo> rpt_add_frd_info = PBField.initRepeatMessage(oidb_0x829$AddFrdInfo.class);
}
