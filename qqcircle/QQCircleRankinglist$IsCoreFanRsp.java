package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$IsCoreFanRsp extends MessageMicro<QQCircleRankinglist$IsCoreFanRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, QQCircleRankinglist$IsCoreFanRsp.class);
    public final PBRepeatMessageField<QQCircleRankinglist$BoolMapEntry> result = PBField.initRepeatMessage(QQCircleRankinglist$BoolMapEntry.class);
}
