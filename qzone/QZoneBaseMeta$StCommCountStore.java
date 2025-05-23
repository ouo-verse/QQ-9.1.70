package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StCommCountStore extends MessageMicro<QZoneBaseMeta$StCommCountStore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"poly_infos"}, new Object[]{null}, QZoneBaseMeta$StCommCountStore.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StPolyInfoData> poly_infos = PBField.initRepeatMessage(QZoneBaseMeta$StPolyInfoData.class);
}
