package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe09$ReqBody extends MessageMicro<oidb_0xe09$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_item"}, new Object[]{null}, oidb_0xe09$ReqBody.class);
    public final PBRepeatMessageField<oidb_0xe09$reqItem> rpt_item = PBField.initRepeatMessage(oidb_0xe09$reqItem.class);
}
