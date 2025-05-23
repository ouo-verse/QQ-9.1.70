package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$AuthDeviceSucceedData extends MessageMicro<GetLocalPhone$AuthDeviceSucceedData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_auth_device_succceed_sig"}, new Object[]{""}, GetLocalPhone$AuthDeviceSucceedData.class);
    public final PBStringField str_auth_device_succceed_sig = PBField.initString("");
}
