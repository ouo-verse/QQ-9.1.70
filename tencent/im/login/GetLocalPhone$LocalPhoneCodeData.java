package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$LocalPhoneCodeData extends MessageMicro<GetLocalPhone$LocalPhoneCodeData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_code_data", "int32_channel_id"}, new Object[]{"", 0}, GetLocalPhone$LocalPhoneCodeData.class);
    public final PBStringField str_code_data = PBField.initString("");
    public final PBInt32Field int32_channel_id = PBField.initInt32(0);
}
