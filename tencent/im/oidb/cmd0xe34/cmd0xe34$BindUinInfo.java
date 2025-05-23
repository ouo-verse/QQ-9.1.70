package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe34$BindUinInfo extends MessageMicro<cmd0xe34$BindUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_uin", "uint32_app_id", "uint32_instance_id", "msg_login_sig"}, new Object[]{0L, 0, 0, null}, cmd0xe34$BindUinInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public cmd0xe34$LoginSig msg_login_sig = new cmd0xe34$LoginSig();
}
