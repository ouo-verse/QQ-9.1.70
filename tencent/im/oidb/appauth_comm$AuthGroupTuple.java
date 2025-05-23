package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$AuthGroupTuple extends MessageMicro<appauth_comm$AuthGroupTuple> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"auth_group_type", "auth_group_id"}, new Object[]{0, 0}, appauth_comm$AuthGroupTuple.class);
    public final PBUInt32Field auth_group_type = PBField.initUInt32(0);
    public final PBUInt32Field auth_group_id = PBField.initUInt32(0);
}
