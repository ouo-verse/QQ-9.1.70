package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$PushArkMessageRequest extends MessageMicro<ShadowShareArkMessage$PushArkMessageRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"businessId", "receiverType", "receiverId", "jumpInfo", "displayInfo"}, new Object[]{"", 0, "", null, null}, ShadowShareArkMessage$PushArkMessageRequest.class);
    public final PBStringField businessId = PBField.initString("");
    public final PBEnumField receiverType = PBField.initEnum(0);
    public final PBStringField receiverId = PBField.initString("");
    public ShadowShareArkMessage$JumpInfo jumpInfo = new ShadowShareArkMessage$JumpInfo();
    public ShadowShareArkMessage$DisplayInfo displayInfo = new ShadowShareArkMessage$DisplayInfo();
}
