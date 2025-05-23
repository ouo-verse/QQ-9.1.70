package tencent.im.oidb.cmd0xb6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb6e$RspBody extends MessageMicro<Oidb_0xb6e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_lost", "rpt_friends_info"}, new Object[]{0, null}, Oidb_0xb6e$RspBody.class);
    public final PBInt32Field is_lost = PBField.initInt32(0);
    public final PBRepeatMessageField<Oidb_0xb6e$AppFriendsInfo> rpt_friends_info = PBField.initRepeatMessage(Oidb_0xb6e$AppFriendsInfo.class);
}
