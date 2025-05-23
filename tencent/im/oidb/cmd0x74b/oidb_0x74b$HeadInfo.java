package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x74b$HeadInfo extends MessageMicro<oidb_0x74b$HeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 34, 40, 48, 88}, new String[]{"uint32_id", "rpt_videoheadlist", "str_photohead", "uint32_timestamp", "uint32_type", "uint32_invalid"}, new Object[]{0, null, "", 0, 0, 0}, oidb_0x74b$HeadInfo.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x74b$VideoHeadInfo> rpt_videoheadlist = PBField.initRepeatMessage(oidb_0x74b$VideoHeadInfo.class);
    public final PBUInt32Field uint32_invalid = PBField.initUInt32(0);
    public final PBStringField str_photohead = PBField.initString("");
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
