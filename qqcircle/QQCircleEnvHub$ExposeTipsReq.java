package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$ExposeTipsReq extends MessageMicro<QQCircleEnvHub$ExposeTipsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userId", "tipsId"}, new Object[]{"", 0}, QQCircleEnvHub$ExposeTipsReq.class);
    public final PBStringField userId = PBField.initString("");
    public final PBInt32Field tipsId = PBField.initInt32(0);
}
