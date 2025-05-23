package tencent.im.oidb.register;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class RegisterConfigPB$GetConfigRsp extends MessageMicro<RegisterConfigPB$GetConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"need_update", "md5", "head_configs", "background_configs", "global_config"}, new Object[]{Boolean.FALSE, "", null, null, null}, RegisterConfigPB$GetConfigRsp.class);
    public final PBBoolField need_update = PBField.initBool(false);
    public final PBStringField md5 = PBField.initString("");
    public final PBRepeatMessageField<RegisterConfigPB$HeadConfig> head_configs = PBField.initRepeatMessage(RegisterConfigPB$HeadConfig.class);
    public final PBRepeatMessageField<RegisterConfigPB$BackgroundConfig> background_configs = PBField.initRepeatMessage(RegisterConfigPB$BackgroundConfig.class);
    public RegisterConfigPB$GlobalConfig global_config = new MessageMicro<RegisterConfigPB$GlobalConfig>() { // from class: tencent.im.oidb.register.RegisterConfigPB$GlobalConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"pre_rec_num", "max_loading_time"}, new Object[]{0, 0L}, RegisterConfigPB$GlobalConfig.class);
        public final PBInt32Field pre_rec_num = PBField.initInt32(0);
        public final PBUInt64Field max_loading_time = PBField.initUInt64(0);
    };
}
