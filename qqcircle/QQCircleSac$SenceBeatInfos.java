package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSac$SenceBeatInfos extends MessageMicro<QQCircleSac$SenceBeatInfos> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, QQCircleSac$SenceBeatInfos.class);
    public final PBRepeatMessageField<QQCircleSac$SenceBeatInfo> infos = PBField.initRepeatMessage(QQCircleSac$SenceBeatInfo.class);
}
