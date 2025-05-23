package qqlogin.nt_ldm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NTLoginDeviceManager$LoginApp extends MessageMicro<NTLoginDeviceManager$LoginApp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"guid", "app_id", "app_name"}, new Object[]{ByteStringMicro.EMPTY, 0, ""}, NTLoginDeviceManager$LoginApp.class);
    public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBStringField app_name = PBField.initString("");
}
