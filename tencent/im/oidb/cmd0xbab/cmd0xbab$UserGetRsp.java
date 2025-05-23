package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$UserGetRsp extends MessageMicro<cmd0xbab$UserGetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"policy", "privilege_flag", "member_number", "exp_remain_time", "exp_set_time"}, new Object[]{0, 0, 0, 0, 0}, cmd0xbab$UserGetRsp.class);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
    public final PBUInt32Field member_number = PBField.initUInt32(0);
    public final PBUInt32Field exp_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
}
