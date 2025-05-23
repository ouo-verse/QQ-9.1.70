package tencent.im.oidb.cmd0x5d1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d1$ClearFriendIdReq extends MessageMicro<Oidb_0x5d1$ClearFriendIdReq> {
    public static final int RPT_UINT64_FRIENDS_FIELD_NUMBER = 3;
    public static final int UINT32_IF_CHECK_SEQ_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_if_check_seq", "uint64_seq", "rpt_uint64_friends"}, new Object[]{0, 0L, 0L}, Oidb_0x5d1$ClearFriendIdReq.class);
    public final PBUInt32Field uint32_if_check_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_friends = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
