package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTianShu$RspEntry extends MessageMicro<QQCircleTianShu$RspEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0, null}, QQCircleTianShu$RspEntry.class);
    public final PBUInt32Field key = PBField.initUInt32(0);
    public QQCircleTianShu$AdPlacementInfo value = new QQCircleTianShu$AdPlacementInfo();
}
