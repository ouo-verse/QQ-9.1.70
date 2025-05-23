package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$DoSRRsp extends MessageMicro<SuperResolution$DoSRRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"expected_time", "task_id"}, new Object[]{0L, ""}, SuperResolution$DoSRRsp.class);
    public final PBInt64Field expected_time = PBField.initInt64(0);
    public final PBStringField task_id = PBField.initString("");
}
