package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xcf8$ConfigGroupInfo extends MessageMicro<oidb_cmd0xcf8$ConfigGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"config_info"}, new Object[]{null}, oidb_cmd0xcf8$ConfigGroupInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xcf8$ConfigInfo> config_info = PBField.initRepeatMessage(oidb_cmd0xcf8$ConfigInfo.class);
}
