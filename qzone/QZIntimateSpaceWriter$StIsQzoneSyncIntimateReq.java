package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq extends MessageMicro<QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"content", "uin"}, new Object[]{"", ""}, QZIntimateSpaceWriter$StIsQzoneSyncIntimateReq.class);
    public final PBStringField content = PBField.initString("");
    public final PBRepeatField<String> uin = PBField.initRepeat(PBStringField.__repeatHelper__);
}
