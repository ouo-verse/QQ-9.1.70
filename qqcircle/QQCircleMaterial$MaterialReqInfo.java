package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleMaterial$MaterialReqInfo extends MessageMicro<QQCircleMaterial$MaterialReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"detail", "ToUin", "RecentPubTime", "FansNum", "FeedsNum"}, new Object[]{null, "", 0L, 0L, 0L}, QQCircleMaterial$MaterialReqInfo.class);
    public final PBRepeatMessageField<QQCircleMaterial$MaterialInfo> detail = PBField.initRepeatMessage(QQCircleMaterial$MaterialInfo.class);
    public final PBStringField ToUin = PBField.initString("");
    public final PBInt64Field RecentPubTime = PBField.initInt64(0);
    public final PBInt64Field FansNum = PBField.initInt64(0);
    public final PBInt64Field FeedsNum = PBField.initInt64(0);
}
