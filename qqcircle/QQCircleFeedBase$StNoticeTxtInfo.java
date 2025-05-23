package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StNoticeTxtInfo extends MessageMicro<QQCircleFeedBase$StNoticeTxtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48}, new String[]{"content", "subContent", "summary", "actionType", "schemaUrl", "contentShowCutOff"}, new Object[]{"", "", "", 0, "", Boolean.FALSE}, QQCircleFeedBase$StNoticeTxtInfo.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField subContent = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBStringField schemaUrl = PBField.initString("");
    public final PBBoolField contentShowCutOff = PBField.initBool(false);
}
