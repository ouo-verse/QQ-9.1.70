package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$AddFriendVerifyInfo extends MessageMicro<FrdSysMsg$AddFriendVerifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_type", "str_url", "str_verify_info"}, new Object[]{0, "", ""}, FrdSysMsg$AddFriendVerifyInfo.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_verify_info = PBField.initString("");
}
