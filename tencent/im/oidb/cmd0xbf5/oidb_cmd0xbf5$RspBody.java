package tencent.im.oidb.cmd0xbf5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbf5$RspBody extends MessageMicro<oidb_cmd0xbf5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_notification", "str_avatar"}, new Object[]{0, ""}, oidb_cmd0xbf5$RspBody.class);
    public final PBUInt32Field uint32_notification = PBField.initUInt32(0);
    public final PBStringField str_avatar = PBField.initString("");
}
