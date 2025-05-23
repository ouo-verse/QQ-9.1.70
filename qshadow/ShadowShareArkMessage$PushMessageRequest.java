package qshadow;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$PushMessageRequest extends MessageMicro<ShadowShareArkMessage$PushMessageRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58}, new String[]{"serviceType", "receiverID", "prompt", "groupID", "serviceId", "sdkVersion", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID}, new Object[]{0, "", "", "", 0, "", ""}, ShadowShareArkMessage$PushMessageRequest.class);
    public final PBUInt32Field serviceType = PBField.initUInt32(0);
    public final PBStringField receiverID = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBStringField groupID = PBField.initString("");
    public final PBEnumField serviceId = PBField.initEnum(0);
    public final PBStringField sdkVersion = PBField.initString("");
    public final PBStringField materialId = PBField.initString("");
}
