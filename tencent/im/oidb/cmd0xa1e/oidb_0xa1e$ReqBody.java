package tencent.im.oidb.cmd0xa1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa1e$ReqBody extends MessageMicro<oidb_0xa1e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"rpt_app_click", "platform", "position"}, new Object[]{null, 0, 0}, oidb_0xa1e$ReqBody.class);
    public final PBRepeatMessageField<oidb_0xa1e$AppClick> rpt_app_click = PBField.initRepeatMessage(oidb_0xa1e$AppClick.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field position = PBField.initUInt32(0);
}
