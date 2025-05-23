package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$QuestionFeedbackInfo extends MessageMicro<AvGameCommon$QuestionFeedbackInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"content", "duration", "content_md5"}, new Object[]{"", 0, ""}, AvGameCommon$QuestionFeedbackInfo.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField content_md5 = PBField.initString("");
}
