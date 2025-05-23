package tencent.im.oidb.cmd0x10af;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10af$Layout extends MessageMicro<oidb_0x10af$Layout> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"type", "action", "title", "layout_data"}, new Object[]{0, 0, "", null}, oidb_0x10af$Layout.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x10af$LayoutData> layout_data = PBField.initRepeatMessage(oidb_0x10af$LayoutData.class);
}
