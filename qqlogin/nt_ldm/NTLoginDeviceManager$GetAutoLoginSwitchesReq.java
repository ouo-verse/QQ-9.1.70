package qqlogin.nt_ldm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NTLoginDeviceManager$GetAutoLoginSwitchesReq extends MessageMicro<NTLoginDeviceManager$GetAutoLoginSwitchesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"auto_login_switches"}, new Object[]{null}, NTLoginDeviceManager$GetAutoLoginSwitchesReq.class);
    public final PBRepeatMessageField<NTLoginDeviceManager$AutoLoginSwitch> auto_login_switches = PBField.initRepeatMessage(NTLoginDeviceManager$AutoLoginSwitch.class);
}
