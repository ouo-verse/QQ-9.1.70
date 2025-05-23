package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StReSignFeatureRsp extends MessageMicro<QZIntimateCheckIn$StReSignFeatureRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"feature_toggle", "space_create_time"}, new Object[]{Boolean.FALSE, 0L}, QZIntimateCheckIn$StReSignFeatureRsp.class);
    public final PBBoolField feature_toggle = PBField.initBool(false);
    public final PBInt64Field space_create_time = PBField.initInt64(0);
}
