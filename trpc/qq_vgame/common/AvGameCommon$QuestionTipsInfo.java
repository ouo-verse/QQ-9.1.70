package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$QuestionTipsInfo extends MessageMicro<AvGameCommon$QuestionTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_delay_ts", "tips"}, new Object[]{0, ""}, AvGameCommon$QuestionTipsInfo.class);
    public final PBUInt32Field show_delay_ts = PBField.initUInt32(0);
    public final PBStringField tips = PBField.initString("");
}
