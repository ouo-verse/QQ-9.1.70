package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StCheckinListReq extends MessageMicro<QZIntimateCheckIn$StCheckinListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"space_id", "date_begin", "date_end"}, new Object[]{"", "", ""}, QZIntimateCheckIn$StCheckinListReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField date_begin = PBField.initString("");
    public final PBStringField date_end = PBField.initString("");
}
