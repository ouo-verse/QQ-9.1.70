package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$GetOneHeadConfigReq extends MessageMicro<RegisterConfigPB$GetOneHeadConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uin", "config_id", "gender", "version"}, new Object[]{0L, 0, 0, ""}, RegisterConfigPB$GetOneHeadConfigReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field config_id = PBField.initInt32(0);
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBStringField version = PBField.initString("");
}
