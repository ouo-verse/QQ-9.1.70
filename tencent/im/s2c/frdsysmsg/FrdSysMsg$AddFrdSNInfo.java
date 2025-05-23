package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$AddFrdSNInfo extends MessageMicro<FrdSysMsg$AddFrdSNInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_not_see_dynamic", "uint32_set_sn"}, new Object[]{0, 0}, FrdSysMsg$AddFrdSNInfo.class);
    public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
}
