package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetSmartMaterialMusicReq extends MessageMicro<QQCircleSmartMatchMusic$GetSmartMaterialMusicReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"material_id"}, new Object[]{""}, QQCircleSmartMatchMusic$GetSmartMaterialMusicReq.class);
    public final PBStringField material_id = PBField.initString("");
}
