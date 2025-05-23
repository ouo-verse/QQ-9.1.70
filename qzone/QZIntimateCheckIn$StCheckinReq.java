package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StCheckinReq extends MessageMicro<QZIntimateCheckIn$StCheckinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"space_id"}, new Object[]{""}, QZIntimateCheckIn$StCheckinReq.class);
    public final PBStringField space_id = PBField.initString("");
}
