package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7f5$LabelInfo extends MessageMicro<cmd0x7f5$LabelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int32_result", "uint64_group_code", "rpt_group_label"}, new Object[]{0, 0L, null}, cmd0x7f5$LabelInfo.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x7f5$Label> rpt_group_label = PBField.initRepeatMessage(cmd0x7f5$Label.class);
}
