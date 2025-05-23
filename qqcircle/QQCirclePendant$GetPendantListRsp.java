package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCirclePendant$GetPendantListRsp extends MessageMicro<QQCirclePendant$GetPendantListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uin", "userPendantInfo", "attachInfo", "hasMore"}, new Object[]{0L, null, "", Boolean.FALSE}, QQCirclePendant$GetPendantListRsp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<QQCirclePendant$UserPendantInfo> userPendantInfo = PBField.initRepeatMessage(QQCirclePendant$UserPendantInfo.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBoolField hasMore = PBField.initBool(false);
}
