package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc05$GetAuthAppListReq extends MessageMicro<oidb_0xc05$GetAuthAppListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start", "limit"}, new Object[]{0, 0}, oidb_0xc05$GetAuthAppListReq.class);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
}
