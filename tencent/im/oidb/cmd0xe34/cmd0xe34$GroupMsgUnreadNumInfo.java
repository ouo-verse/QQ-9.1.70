package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe34$GroupMsgUnreadNumInfo extends MessageMicro<cmd0xe34$GroupMsgUnreadNumInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_num", "msg_num", "last_msg_time"}, new Object[]{0, 0, 0}, cmd0xe34$GroupMsgUnreadNumInfo.class);
    public final PBUInt32Field group_num = PBField.initUInt32(0);
    public final PBUInt32Field msg_num = PBField.initUInt32(0);
    public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
}
