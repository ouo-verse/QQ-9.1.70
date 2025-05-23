package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$GetRegisterHeadConfigRsp extends MessageMicro<RegisterConfigPB$GetRegisterHeadConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"register_head_configs"}, new Object[]{null}, RegisterConfigPB$GetRegisterHeadConfigRsp.class);
    public final PBRepeatMessageField<RegisterConfigPB$RegisterHeadConfig> register_head_configs = PBField.initRepeatMessage(RegisterConfigPB$RegisterHeadConfig.class);
}
