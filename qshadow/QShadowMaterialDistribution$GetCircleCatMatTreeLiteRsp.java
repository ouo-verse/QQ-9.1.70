package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp extends MessageMicro<QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"materialListURL", "categoryMaterialsMappings", "materialInfos", "cdnPrefixURL", "filterableInfos", Headers.ETAG, "pkey", "md5hash"}, new Object[]{"", null, null, "", null, "", "", ""}, QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.class);
    public final PBStringField materialListURL = PBField.initString("");
    public final PBRepeatMessageField<QShadowMaterialDistribution$CategoryMaterialsMapping> categoryMaterialsMappings = PBField.initRepeatMessage(QShadowMaterialDistribution$CategoryMaterialsMapping.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$MaterialInfo> materialInfos = PBField.initRepeatMessage(QShadowMetaMaterial$MaterialInfo.class);
    public final PBStringField cdnPrefixURL = PBField.initString("");
    public final PBRepeatMessageField<QShadowMaterialDistribution$FilterableInfo> filterableInfos = PBField.initRepeatMessage(QShadowMaterialDistribution$FilterableInfo.class);
    public final PBStringField etag = PBField.initString("");
    public final PBStringField pkey = PBField.initString("");
    public final PBStringField md5hash = PBField.initString("");
}
