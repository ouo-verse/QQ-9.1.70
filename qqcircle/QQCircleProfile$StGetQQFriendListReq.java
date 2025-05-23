package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StGetQQFriendListReq extends MessageMicro<QQCircleProfile$StGetQQFriendListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "circleUser"}, new Object[]{0, Boolean.FALSE}, QQCircleProfile$StGetQQFriendListReq.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBBoolField circleUser = PBField.initBool(false);
}
