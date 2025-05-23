package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetCircleCatMatTreeRsp extends MessageMicro<QShadowMaterialDistribution$GetCircleCatMatTreeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"categories", Headers.ETAG, "filterableInfos"}, new Object[]{null, "", null}, QShadowMaterialDistribution$GetCircleCatMatTreeRsp.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$CategoryInfo> categories = PBField.initRepeatMessage(QShadowMetaMaterial$CategoryInfo.class);
    public final PBStringField etag = PBField.initString("");
    public final PBRepeatMessageField<QShadowMaterialDistribution$FilterableInfo> filterableInfos = PBField.initRepeatMessage(QShadowMaterialDistribution$FilterableInfo.class);
}
