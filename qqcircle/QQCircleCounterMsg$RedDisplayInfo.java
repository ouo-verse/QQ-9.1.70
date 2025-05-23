package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$RedDisplayInfo extends MessageMicro<QQCircleCounterMsg$RedDisplayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{WidgetCacheConstellationData.NUM, "headImg", "ext", "avatarURL", "bitTypeCertification"}, new Object[]{0, "", "", "", 0}, QQCircleCounterMsg$RedDisplayInfo.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBStringField headImg = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
    public final PBStringField avatarURL = PBField.initString("");
    public final PBInt32Field bitTypeCertification = PBField.initInt32(0);
}
