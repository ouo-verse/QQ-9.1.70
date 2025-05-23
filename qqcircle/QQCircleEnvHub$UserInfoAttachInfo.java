package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$UserInfoAttachInfo extends MessageMicro<QQCircleEnvHub$UserInfoAttachInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"funnyKingNextTime", "lastUserInfo", "nicknameHeadNextTime"}, new Object[]{0L, null, 0L}, QQCircleEnvHub$UserInfoAttachInfo.class);
    public final PBUInt64Field funnyKingNextTime = PBField.initUInt64(0);
    public QQCircleEnvHub$UserInfo lastUserInfo = new QQCircleEnvHub$UserInfo();
    public final PBUInt64Field nicknameHeadNextTime = PBField.initUInt64(0);
}
