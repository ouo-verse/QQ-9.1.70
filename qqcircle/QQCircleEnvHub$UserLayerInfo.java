package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$UserLayerInfo extends MessageMicro<QQCircleEnvHub$UserLayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isHaveLostUser"}, new Object[]{Boolean.FALSE}, QQCircleEnvHub$UserLayerInfo.class);
    public final PBBoolField isHaveLostUser = PBField.initBool(false);
}
