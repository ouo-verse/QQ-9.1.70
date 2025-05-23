package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetMaterialInfoByIdsRsp extends MessageMicro<QShadowMaterialDistribution$GetMaterialInfoByIdsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"materials"}, new Object[]{null}, QShadowMaterialDistribution$GetMaterialInfoByIdsRsp.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$MaterialInfo> materials = PBField.initRepeatMessage(QShadowMetaMaterial$MaterialInfo.class);
}
