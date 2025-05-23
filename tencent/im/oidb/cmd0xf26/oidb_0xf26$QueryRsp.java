package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf26$QueryRsp extends MessageMicro<oidb_0xf26$QueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"auth_item"}, new Object[]{null}, oidb_0xf26$QueryRsp.class);
    public final PBRepeatMessageField<oidb_0xf26$AuthItem> auth_item = PBField.initRepeatMessage(oidb_0xf26$AuthItem.class);
}
