package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$CircleAchievement extends MessageMicro<QQCircleBase$CircleAchievement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66}, new String[]{"rocket", "rocketTitle", "rocketDesc", "rocketToast", "rocketIconUrl", "rocketToastUrl", "rocketButtonDesc", "rocketButtonUrl"}, new Object[]{0, "", "", 0, "", "", "", ""}, QQCircleBase$CircleAchievement.class);
    public final PBInt32Field rocket = PBField.initInt32(0);
    public final PBStringField rocketTitle = PBField.initString("");
    public final PBStringField rocketDesc = PBField.initString("");
    public final PBInt32Field rocketToast = PBField.initInt32(0);
    public final PBStringField rocketIconUrl = PBField.initString("");
    public final PBStringField rocketToastUrl = PBField.initString("");
    public final PBStringField rocketButtonDesc = PBField.initString("");
    public final PBStringField rocketButtonUrl = PBField.initString("");
}
