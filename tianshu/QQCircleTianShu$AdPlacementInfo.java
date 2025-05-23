package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleTianShu$AdPlacementInfo extends MessageMicro<QQCircleTianShu$AdPlacementInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"type", "lst", "next_query_ts", "extInfo", "ctlInfo"}, new Object[]{0, null, 0, "", ""}, QQCircleTianShu$AdPlacementInfo.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBRepeatMessageField<QQCircleTianShu$AdItem> lst = PBField.initRepeatMessage(QQCircleTianShu$AdItem.class);
    public final PBUInt32Field next_query_ts = PBField.initUInt32(0);
    public final PBStringField extInfo = PBField.initString("");
    public final PBStringField ctlInfo = PBField.initString("");
}
