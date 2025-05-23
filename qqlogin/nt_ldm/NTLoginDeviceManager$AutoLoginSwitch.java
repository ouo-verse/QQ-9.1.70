package qqlogin.nt_ldm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NTLoginDeviceManager$AutoLoginSwitch extends MessageMicro<NTLoginDeviceManager$AutoLoginSwitch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"login_app", "encrypt_guid_version", "auto_login", "trusted_device"}, new Object[]{null, 0, 0, 0}, NTLoginDeviceManager$AutoLoginSwitch.class);
    public NTLoginDeviceManager$LoginApp login_app = new NTLoginDeviceManager$LoginApp();
    public final PBUInt32Field encrypt_guid_version = PBField.initUInt32(0);
    public final PBUInt32Field auto_login = PBField.initUInt32(0);
    public final PBUInt32Field trusted_device = PBField.initUInt32(0);
}
