package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$CallBackInfo extends MessageMicro<RegisterConfigPB$CallBackInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{"action_id", "suit_id", "register_head_id", "background_id", "appearence_key", "default_url"}, new Object[]{0, "", 0, 0, "", ""}, RegisterConfigPB$CallBackInfo.class);
    public final PBInt32Field action_id = PBField.initInt32(0);
    public final PBStringField suit_id = PBField.initString("");
    public final PBInt32Field register_head_id = PBField.initInt32(0);
    public final PBInt32Field background_id = PBField.initInt32(0);
    public final PBStringField appearence_key = PBField.initString("");
    public final PBStringField default_url = PBField.initString("");
}
