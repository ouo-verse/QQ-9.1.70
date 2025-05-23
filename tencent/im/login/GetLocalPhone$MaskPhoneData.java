package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$MaskPhoneData extends MessageMicro<GetLocalPhone$MaskPhoneData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_mask_phone", "str_process_cookies", "str_terms_wording", "str_authentication_wording"}, new Object[]{"", "", "", ""}, GetLocalPhone$MaskPhoneData.class);
    public final PBStringField str_mask_phone = PBField.initString("");
    public final PBStringField str_process_cookies = PBField.initString("");
    public final PBStringField str_terms_wording = PBField.initString("");
    public final PBStringField str_authentication_wording = PBField.initString("");
}
