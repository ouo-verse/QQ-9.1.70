package tencent.im.oidb.cmd0x983;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x983$RspBody extends MessageMicro<oidb_cmd0x983$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_addon_list"}, new Object[]{null}, oidb_cmd0x983$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x983$AddonItem> rpt_addon_list = PBField.initRepeatMessage(oidb_cmd0x983$AddonItem.class);
}
