package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneRightAccess$GetUgcRightReq extends MessageMicro<QZoneRightAccess$GetUgcRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"appid", "ugcid", QQWinkConstants.FEEDTIME}, new Object[]{0, "", 0L}, QZoneRightAccess$GetUgcRightReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField ugcid = PBField.initString("");
    public final PBUInt64Field feed_time = PBField.initUInt64(0);
}
