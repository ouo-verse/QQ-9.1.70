package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sync$SyncAppointmentRsp extends MessageMicro<sync$SyncAppointmentRsp> {
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_result"}, new Object[]{0}, sync$SyncAppointmentRsp.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}
