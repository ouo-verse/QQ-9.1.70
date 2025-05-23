package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$LdmSigInfo extends MessageMicro<GetLocalPhone$LdmSigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"sig_type", "str_sig"}, new Object[]{0, ""}, GetLocalPhone$LdmSigInfo.class);
    public final PBEnumField sig_type = PBField.initEnum(0);
    public final PBStringField str_sig = PBField.initString("");
}
