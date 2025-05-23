package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$BackflowPymkDescEntry extends MessageMicro<QQCircleFeedBase$BackflowPymkDescEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"key", "count", "describe", "needDisplay"}, new Object[]{"", 0, "", Boolean.FALSE}, QQCircleFeedBase$BackflowPymkDescEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField describe = PBField.initString("");
    public final PBBoolField needDisplay = PBField.initBool(false);
}
