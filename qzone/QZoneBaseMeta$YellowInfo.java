package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$YellowInfo extends MessageMicro<QZoneBaseMeta$YellowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"yellow_type", "yellow_level", "is_annual_vip"}, new Object[]{0, 0, Boolean.FALSE}, QZoneBaseMeta$YellowInfo.class);
    public final PBInt32Field yellow_type = PBField.initInt32(0);
    public final PBInt32Field yellow_level = PBField.initInt32(0);
    public final PBBoolField is_annual_vip = PBField.initBool(false);
}
