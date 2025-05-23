package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe34$UnReadInfo extends MessageMicro<cmd0xe34$UnReadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_uin", "c2c_info", "group_info", "retcode"}, new Object[]{0L, null, null, 0}, cmd0xe34$UnReadInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public cmd0xe34$C2CMsgUnreadNumInfo c2c_info = new MessageMicro<cmd0xe34$C2CMsgUnreadNumInfo>() { // from class: tencent.im.oidb.cmd0xe34.cmd0xe34$C2CMsgUnreadNumInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"peer_uin_num", "msg_num", "last_msg_time"}, new Object[]{0, 0, 0}, cmd0xe34$C2CMsgUnreadNumInfo.class);
        public final PBUInt32Field peer_uin_num = PBField.initUInt32(0);
        public final PBUInt32Field msg_num = PBField.initUInt32(0);
        public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
    };
    public cmd0xe34$GroupMsgUnreadNumInfo group_info = new cmd0xe34$GroupMsgUnreadNumInfo();
    public final PBInt32Field retcode = PBField.initInt32(0);
}
