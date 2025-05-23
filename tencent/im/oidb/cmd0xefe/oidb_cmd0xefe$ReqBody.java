package tencent.im.oidb.cmd0xefe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xefe$ReqBody extends MessageMicro<oidb_cmd0xefe$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"friend_uin", "last_ts", "deleted"}, new Object[]{0L, 0L, Boolean.FALSE}, oidb_cmd0xefe$ReqBody.class);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBInt64Field last_ts = PBField.initInt64(0);
    public final PBBoolField deleted = PBField.initBool(false);
}
