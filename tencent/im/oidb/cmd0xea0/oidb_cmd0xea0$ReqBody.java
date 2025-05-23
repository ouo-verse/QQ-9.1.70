package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xea0$ReqBody extends MessageMicro<oidb_cmd0xea0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"req_client_type", "version", "channel_id", "channel_name"}, new Object[]{0, "", 0L, ""}, oidb_cmd0xea0$ReqBody.class);
    public final PBUInt32Field req_client_type = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
}
