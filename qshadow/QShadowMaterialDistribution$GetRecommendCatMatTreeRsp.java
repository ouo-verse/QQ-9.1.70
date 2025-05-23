package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetRecommendCatMatTreeRsp extends MessageMicro<QShadowMaterialDistribution$GetRecommendCatMatTreeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"categories", Headers.ETAG}, new Object[]{null, ""}, QShadowMaterialDistribution$GetRecommendCatMatTreeRsp.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$CategoryInfo> categories = PBField.initRepeatMessage(QShadowMetaMaterial$CategoryInfo.class);
    public final PBStringField etag = PBField.initString("");
}
