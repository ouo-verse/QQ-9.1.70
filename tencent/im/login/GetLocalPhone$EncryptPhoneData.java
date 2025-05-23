package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$EncryptPhoneData extends MessageMicro<GetLocalPhone$EncryptPhoneData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24}, new String[]{"str_encypt_phone", "compare_mibao_state"}, new Object[]{"", 0}, GetLocalPhone$EncryptPhoneData.class);
    public final PBStringField str_encypt_phone = PBField.initString("");
    public final PBEnumField compare_mibao_state = PBField.initEnum(0);
}
