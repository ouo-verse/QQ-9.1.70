package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp extends MessageMicro<QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "infos"}, new Object[]{null, null}, QZIntimateSpaceReader$GetIntimateRelationFromQQBasicRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBRepeatMessageField<QZIntimateSpaceReader$RelatationInfo> infos = PBField.initRepeatMessage(QZIntimateSpaceReader$RelatationInfo.class);
}
