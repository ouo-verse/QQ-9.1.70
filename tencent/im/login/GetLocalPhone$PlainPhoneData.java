package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$PlainPhoneData extends MessageMicro<GetLocalPhone$PlainPhoneData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_plain_phone"}, new Object[]{""}, GetLocalPhone$PlainPhoneData.class);
    public final PBStringField str_plain_phone = PBField.initString("");
}
