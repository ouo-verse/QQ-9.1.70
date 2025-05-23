package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StMaterialData extends MessageMicro<QQCircleFeedBase$StMaterialData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"material_id", "material_type", "interactive_type", "simulate_date", "kuolie_data"}, new Object[]{"", "", 0, null, null}, QQCircleFeedBase$StMaterialData.class);
    public final PBStringField material_id = PBField.initString("");
    public final PBStringField material_type = PBField.initString("");
    public final PBUInt32Field interactive_type = PBField.initUInt32(0);
    public QQCircleFeedBase$StSimulateData simulate_date = new QQCircleFeedBase$StSimulateData();
    public QQCircleFeedBase$StKuoliePasterData kuolie_data = new QQCircleFeedBase$StKuoliePasterData();
}
