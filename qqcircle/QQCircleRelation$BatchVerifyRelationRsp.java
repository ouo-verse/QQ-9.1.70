package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$BatchVerifyRelationRsp extends MessageMicro<QQCircleRelation$BatchVerifyRelationRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, QQCircleRelation$BatchVerifyRelationRsp.class);
    public final PBRepeatMessageField<QQCircleRelation$RelationInfo> infos = PBField.initRepeatMessage(QQCircleRelation$RelationInfo.class);
}
