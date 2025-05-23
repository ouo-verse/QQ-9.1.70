package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$AddFriendAuthReqBody extends MessageMicro<QQCircleRelation$AddFriendAuthReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_from_uin", "uint64_to_uin", "source", "extInfos"}, new Object[]{0L, 0L, "", null}, QQCircleRelation$AddFriendAuthReqBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBStringField source = PBField.initString("");
    public final PBRepeatMessageField<QQCircleRelation$ExtendInfo> extInfos = PBField.initRepeatMessage(QQCircleRelation$ExtendInfo.class);
}
