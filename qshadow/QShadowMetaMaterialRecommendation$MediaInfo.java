package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterialRecommendation$MediaInfo extends MessageMicro<QShadowMetaMaterialRecommendation$MediaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"media_type", "width", "height"}, new Object[]{0, 0, 0}, QShadowMetaMaterialRecommendation$MediaInfo.class);
    public final PBInt32Field media_type = PBField.initInt32(0);
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
}
