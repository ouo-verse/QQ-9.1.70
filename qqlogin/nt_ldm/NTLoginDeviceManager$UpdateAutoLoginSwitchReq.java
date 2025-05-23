package qqlogin.nt_ldm;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NTLoginDeviceManager$UpdateAutoLoginSwitchReq extends MessageMicro<NTLoginDeviceManager$UpdateAutoLoginSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"auto_login_switch"}, new Object[]{null}, NTLoginDeviceManager$UpdateAutoLoginSwitchReq.class);
    public NTLoginDeviceManager$AutoLoginSwitch auto_login_switch = new NTLoginDeviceManager$AutoLoginSwitch();
}
