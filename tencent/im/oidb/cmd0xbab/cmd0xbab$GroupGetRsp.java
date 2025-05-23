package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$GroupGetRsp extends MessageMicro<cmd0xbab$GroupGetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64}, new String[]{"policy", "user_list", "total_members", "privilege_members", "member_number", "exp_remain_time", "exp_set_time", "privilege_flag"}, new Object[]{0, null, 0, 0, 0, 0, 0, 0}, cmd0xbab$GroupGetRsp.class);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xbab$UserInfo> user_list = PBField.initRepeatMessage(cmd0xbab$UserInfo.class);
    public final PBUInt32Field total_members = PBField.initUInt32(0);
    public final PBUInt32Field privilege_members = PBField.initUInt32(0);
    public final PBUInt32Field member_number = PBField.initUInt32(0);
    public final PBUInt32Field exp_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
}
