package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$IsCollectedReq extends MessageMicro<QQCircleSmartMatchMusic$IsCollectedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"collection_id", "mids"}, new Object[]{"", ""}, QQCircleSmartMatchMusic$IsCollectedReq.class);
    public final PBStringField collection_id = PBField.initString("");
    public final PBRepeatField<String> mids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
