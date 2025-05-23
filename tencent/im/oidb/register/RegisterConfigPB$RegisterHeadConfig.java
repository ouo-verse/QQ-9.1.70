package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$RegisterHeadConfig extends MessageMicro<RegisterConfigPB$RegisterHeadConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 37, 42, 50}, new String[]{"background_config", "out_bounds_clipper_url", "default_url", "mask_rate", "call_back_info", "suit_id"}, new Object[]{null, "", "", Float.valueOf(0.0f), ByteStringMicro.EMPTY, ""}, RegisterConfigPB$RegisterHeadConfig.class);
    public RegisterConfigPB$BackgroundConfig background_config = new RegisterConfigPB$BackgroundConfig();
    public final PBStringField out_bounds_clipper_url = PBField.initString("");
    public final PBStringField default_url = PBField.initString("");
    public final PBFloatField mask_rate = PBField.initFloat(0.0f);
    public final PBBytesField call_back_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField suit_id = PBField.initString("");
}
