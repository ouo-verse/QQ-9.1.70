package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StImageBusiData extends MessageMicro<QQCircleFeedBase$StImageBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"simulate_date", "kuolie_data", "material_datas"}, new Object[]{null, null, null}, QQCircleFeedBase$StImageBusiData.class);
    public QQCircleFeedBase$StSimulateData simulate_date = new QQCircleFeedBase$StSimulateData();
    public QQCircleFeedBase$StKuoliePasterData kuolie_data = new QQCircleFeedBase$StKuoliePasterData();
    public final PBRepeatMessageField<QQCircleFeedBase$StMaterialData> material_datas = PBField.initRepeatMessage(QQCircleFeedBase$StMaterialData.class);
}
