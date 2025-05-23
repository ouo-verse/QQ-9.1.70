package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$PenguinProfile extends MessageMicro<QQCircleProfile$PenguinProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uin", "mediaID", "mediaName", "mediaIcon", "introduction"}, new Object[]{0, "", "", "", ""}, QQCircleProfile$PenguinProfile.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField mediaID = PBField.initString("");
    public final PBStringField mediaName = PBField.initString("");
    public final PBStringField mediaIcon = PBField.initString("");
    public final PBStringField introduction = PBField.initString("");
}
