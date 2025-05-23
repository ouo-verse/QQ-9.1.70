package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$GetClassifyRsp extends MessageMicro<GetRecommendWords$GetClassifyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"code", "message", "ver", "classify"}, new Object[]{0, "", 0, null}, GetRecommendWords$GetClassifyRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBInt32Field ver = PBField.initInt32(0);
    public final PBRepeatMessageField<GetRecommendWords$Classify> classify = PBField.initRepeatMessage(GetRecommendWords$Classify.class);
}
