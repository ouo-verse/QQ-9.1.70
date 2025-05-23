package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$ReqBody extends MessageMicro<faceroam_sso$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48}, new String[]{"comm", "uint64_uin", "uint32_sub_cmd", "reqcmd_0x01", "reqcmd_0x02", "uint32_capacity_incr"}, new Object[]{null, 0L, 0, null, null, 0}, faceroam_sso$ReqBody.class);
    public faceroam_sso$PlatInfo comm = new faceroam_sso$PlatInfo();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public faceroam_sso$ReqUserInfo reqcmd_0x01 = new faceroam_sso$ReqUserInfo();
    public faceroam_sso$ReqDeleteItem reqcmd_0x02 = new faceroam_sso$ReqDeleteItem();
    public final PBUInt32Field uint32_capacity_incr = PBField.initUInt32(0);
}
