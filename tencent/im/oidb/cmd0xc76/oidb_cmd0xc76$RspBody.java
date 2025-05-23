package tencent.im.oidb.cmd0xc76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc76$RspBody extends MessageMicro<oidb_cmd0xc76$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"cmd", "main", "apps"}, new Object[]{0, null, null}, oidb_cmd0xc76$RspBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public oidb_cmd0xc76$Setting main = new oidb_cmd0xc76$Setting();
    public oidb_cmd0xc76$Setting apps = new oidb_cmd0xc76$Setting();
}
