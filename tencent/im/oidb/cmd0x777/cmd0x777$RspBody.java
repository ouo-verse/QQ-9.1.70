package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x777$RspBody extends MessageMicro<cmd0x777$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_add_frd_info"}, new Object[]{null}, cmd0x777$RspBody.class);
    public final PBRepeatMessageField<cmd0x777$AddFrdInfo> rpt_add_frd_info = PBField.initRepeatMessage(cmd0x777$AddFrdInfo.class);
}
