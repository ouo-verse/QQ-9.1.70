package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc76$ReqBody extends MessageMicro<oidb_cmd0xc76$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"cmd", "apps"}, new Object[]{0, null}, oidb_cmd0xc76$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xc76$Item> apps = PBField.initRepeatMessage(oidb_cmd0xc76$Item.class);
}
