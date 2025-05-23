package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$GroupOnlineInfo extends MessageMicro<oidb_0xa2a$GroupOnlineInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"group_id", "online_num", "star_num", "hok_num"}, new Object[]{0L, 0, 0, 0}, oidb_0xa2a$GroupOnlineInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field online_num = PBField.initUInt32(0);
    public final PBUInt32Field star_num = PBField.initUInt32(0);
    public final PBUInt32Field hok_num = PBField.initUInt32(0);
}
