package tencent.im.oidb.cmd0xf8e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf8e$RspBody extends MessageMicro<oidb_0xf8e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"info", "rpt_group_list", "exp_time"}, new Object[]{null, null, 0}, oidb_0xf8e$RspBody.class);
    public oidb_0xf8e$InfoValue info = new oidb_0xf8e$InfoValue();
    public final PBRepeatMessageField<oidb_0xf8e$UserNode> rpt_group_list = PBField.initRepeatMessage(oidb_0xf8e$UserNode.class);
    public final PBUInt32Field exp_time = PBField.initUInt32(0);
}
