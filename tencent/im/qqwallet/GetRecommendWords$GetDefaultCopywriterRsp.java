package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$GetDefaultCopywriterRsp extends MessageMicro<GetRecommendWords$GetDefaultCopywriterRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "message", "copywriter"}, new Object[]{0, "", null}, GetRecommendWords$GetDefaultCopywriterRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBRepeatMessageField<GetRecommendWords$CopyWriter> copywriter = PBField.initRepeatMessage(GetRecommendWords$CopyWriter.class);
}
