package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetRedPointsInfoByUserIDReq extends MessageMicro<QQCircleCounter$GetRedPointsInfoByUserIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uid"}, new Object[]{""}, QQCircleCounter$GetRedPointsInfoByUserIDReq.class);
    public final PBStringField uid = PBField.initString("");
}
