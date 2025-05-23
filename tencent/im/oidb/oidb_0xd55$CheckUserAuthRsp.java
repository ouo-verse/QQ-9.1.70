package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$CheckUserAuthRsp extends MessageMicro<oidb_0xd55$CheckUserAuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"auth_results"}, new Object[]{null}, oidb_0xd55$CheckUserAuthRsp.class);
    public final PBRepeatMessageField<oidb_0xd55$UserAuthResult> auth_results = PBField.initRepeatMessage(oidb_0xd55$UserAuthResult.class);
}
