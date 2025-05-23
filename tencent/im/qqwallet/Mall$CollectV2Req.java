package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Mall$CollectV2Req extends MessageMicro<Mall$CollectV2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"field", "app_id", "card_id", "channel_id", "source"}, new Object[]{0, 0, "", 0, ""}, Mall$CollectV2Req.class);
    public final PBInt32Field field = PBField.initInt32(0);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBStringField card_id = PBField.initString("");
    public final PBInt32Field channel_id = PBField.initInt32(0);
    public final PBStringField source = PBField.initString("");
}
