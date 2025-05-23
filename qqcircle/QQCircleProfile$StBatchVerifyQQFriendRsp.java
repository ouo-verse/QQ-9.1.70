package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchVerifyQQFriendRsp extends MessageMicro<QQCircleProfile$StBatchVerifyQQFriendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"friendInfoList"}, new Object[]{null}, QQCircleProfile$StBatchVerifyQQFriendRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$StQQFriendInfo> friendInfoList = PBField.initRepeatMessage(QQCircleProfile$StQQFriendInfo.class);
}
