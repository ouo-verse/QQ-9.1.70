package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp extends MessageMicro<QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"pmBeginShow", "followState", "blackState", "showGuideBar"}, new Object[]{"", 0, 0, Boolean.FALSE}, QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.class);
    public final PBStringField pmBeginShow = PBField.initString("");
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBUInt32Field blackState = PBField.initUInt32(0);
    public final PBBoolField showGuideBar = PBField.initBool(false);
}
