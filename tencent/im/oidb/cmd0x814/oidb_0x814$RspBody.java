package tencent.im.oidb.cmd0x814;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x814$RspBody extends MessageMicro<oidb_0x814$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"total", "activity_list", "url"}, new Object[]{0, null, ""}, oidb_0x814$RspBody.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x814$Activity> activity_list = PBField.initRepeatMessage(oidb_0x814$Activity.class);
    public final PBStringField url = PBField.initString("");
}
