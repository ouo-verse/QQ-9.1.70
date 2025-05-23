package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$UserAchievementReq extends MessageMicro<QzoneActivityPB$UserAchievementReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uin"}, new Object[]{""}, QzoneActivityPB$UserAchievementReq.class);
    public final PBStringField uin = PBField.initString("");
}
