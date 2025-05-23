package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankingstore$DovInfoStores extends MessageMicro<QQCircleRankingstore$DovInfoStores> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dovs"}, new Object[]{null}, QQCircleRankingstore$DovInfoStores.class);
    public final PBRepeatMessageField<QQCircleRankingstore$DovInfoStore> dovs = PBField.initRepeatMessage(QQCircleRankingstore$DovInfoStore.class);
}
