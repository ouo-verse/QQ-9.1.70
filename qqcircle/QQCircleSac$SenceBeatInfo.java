package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSac$SenceBeatInfo extends MessageMicro<QQCircleSac$SenceBeatInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"sence", "beatStatus", "endTime", "desc"}, new Object[]{0, 0, 0L, ""}, QQCircleSac$SenceBeatInfo.class);
    public final PBInt32Field sence = PBField.initInt32(0);
    public final PBEnumField beatStatus = PBField.initEnum(0);
    public final PBInt64Field endTime = PBField.initInt64(0);
    public final PBStringField desc = PBField.initString("");
}
