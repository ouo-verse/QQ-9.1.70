package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x791$SetAppidOpt extends MessageMicro<oidb_0x791$SetAppidOpt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_appid", "set_reddot_opt"}, new Object[]{0, null}, oidb_0x791$SetAppidOpt.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public oidb_0x791$SetRedDotOpt set_reddot_opt = new oidb_0x791$SetRedDotOpt();
}
