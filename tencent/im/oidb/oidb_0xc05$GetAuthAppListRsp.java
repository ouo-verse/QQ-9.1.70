package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc05$GetAuthAppListRsp extends MessageMicro<oidb_0xc05$GetAuthAppListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"total_count", "appinfos", "cur_index"}, new Object[]{0, null, 0}, oidb_0xc05$GetAuthAppListRsp.class);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqconnect$Appinfo> appinfos = PBField.initRepeatMessage(qqconnect$Appinfo.class);
    public final PBUInt32Field cur_index = PBField.initUInt32(0);
}
