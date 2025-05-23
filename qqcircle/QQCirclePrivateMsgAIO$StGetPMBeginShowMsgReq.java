package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq extends MessageMicro<QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"userId"}, new Object[]{""}, QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq.class);
    public final PBStringField userId = PBField.initString("");
}
