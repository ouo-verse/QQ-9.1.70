package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleTianShu$AdPosItem extends MessageMicro<QQCircleTianShu$AdPosItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 114}, new String[]{"posId", "nNeedCnt", "extra_info"}, new Object[]{0, 0, null}, QQCircleTianShu$AdPosItem.class);
    public final PBUInt32Field posId = PBField.initUInt32(0);
    public final PBUInt32Field nNeedCnt = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleTianShu$MapEntry> extra_info = PBField.initRepeatMessage(QQCircleTianShu$MapEntry.class);
}
