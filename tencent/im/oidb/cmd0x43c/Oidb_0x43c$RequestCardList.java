package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$RequestCardList extends MessageMicro<Oidb_0x43c$RequestCardList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"seq", "next_flag", "req_num"}, new Object[]{0, 0, 10}, Oidb_0x43c$RequestCardList.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field next_flag = PBField.initUInt32(0);
    public final PBUInt32Field req_num = PBField.initUInt32(10);
}
