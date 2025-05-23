package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$CollectInfo extends MessageMicro<QQCircleSmartMatchMusic$CollectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"mid", "is_collected"}, new Object[]{"", Boolean.FALSE}, QQCircleSmartMatchMusic$CollectInfo.class);
    public final PBStringField mid = PBField.initString("");
    public final PBBoolField is_collected = PBField.initBool(false);
}
