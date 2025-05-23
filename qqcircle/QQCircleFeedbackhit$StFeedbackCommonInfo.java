package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedbackhit$StFeedbackCommonInfo extends MessageMicro<QQCircleFeedbackhit$StFeedbackCommonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"sourceUin", "feedId", "operationUin", "level", "sourceUinName"}, new Object[]{"", "", "", 0, ""}, QQCircleFeedbackhit$StFeedbackCommonInfo.class);
    public final PBStringField sourceUin = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField operationUin = PBField.initString("");
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBStringField sourceUinName = PBField.initString("");
}
