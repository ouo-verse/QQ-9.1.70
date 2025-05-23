package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class SuperResolution$QueryPermissionsRsp extends MessageMicro<SuperResolution$QueryPermissionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"enable_sr", "rp_middle_hint", "rp_pay_guide_hint1", "rp_pay_guide_hint2", "pp_button_hint", "pp_bottom_hint1", "pp_bottom_hint2", "rp_pay_type", "pp_pay_type"}, new Object[]{Boolean.FALSE, "", "", "", "", "", "", 0, 0}, SuperResolution$QueryPermissionsRsp.class);
    public final PBBoolField enable_sr = PBField.initBool(false);
    public final PBStringField rp_middle_hint = PBField.initString("");
    public final PBStringField rp_pay_guide_hint1 = PBField.initString("");
    public final PBStringField rp_pay_guide_hint2 = PBField.initString("");
    public final PBStringField pp_button_hint = PBField.initString("");
    public final PBStringField pp_bottom_hint1 = PBField.initString("");
    public final PBStringField pp_bottom_hint2 = PBField.initString("");
    public final PBEnumField rp_pay_type = PBField.initEnum(0);
    public final PBEnumField pp_pay_type = PBField.initEnum(0);
}
