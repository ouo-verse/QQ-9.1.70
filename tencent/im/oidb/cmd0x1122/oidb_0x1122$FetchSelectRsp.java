package tencent.im.oidb.cmd0x1122;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1122$FetchSelectRsp extends MessageMicro<oidb_0x1122$FetchSelectRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_perms"}, new Object[]{null}, oidb_0x1122$FetchSelectRsp.class);
    public final PBRepeatMessageField<oidb_0x1122$UserPermission> user_perms = PBField.initRepeatMessage(oidb_0x1122$UserPermission.class);
}
