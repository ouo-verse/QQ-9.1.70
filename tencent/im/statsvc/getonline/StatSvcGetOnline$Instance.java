package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatSvcGetOnline$Instance extends MessageMicro<StatSvcGetOnline$Instance> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_instance_id", "uint32_client_type"}, new Object[]{0, 0}, StatSvcGetOnline$Instance.class);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
}
