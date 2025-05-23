package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$GetRelationTopListRsp extends MessageMicro<QQCircleRelation$GetRelationTopListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"topList"}, new Object[]{null}, QQCircleRelation$GetRelationTopListRsp.class);
    public final PBRepeatMessageField<QQCircleRelation$RelationTopItem> topList = PBField.initRepeatMessage(QQCircleRelation$RelationTopItem.class);
}
