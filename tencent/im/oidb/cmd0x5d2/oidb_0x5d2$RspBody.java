package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d2$RspBody extends MessageMicro<oidb_0x5d2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"sub_cmd", "rsp_get_list", "rsp_get_info"}, new Object[]{0, null, null}, oidb_0x5d2$RspBody.class);
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public oidb_0x5d2$RspGetList rsp_get_list = new MessageMicro<oidb_0x5d2$RspGetList>() { // from class: tencent.im.oidb.cmd0x5d2.oidb_0x5d2$RspGetList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"seq", "list"}, new Object[]{0, null}, oidb_0x5d2$RspGetList.class);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x5d2$FriendList> list = PBField.initRepeatMessage(oidb_0x5d2$FriendList.class);
    };
    public oidb_0x5d2$RspGetInfo rsp_get_info = new MessageMicro<oidb_0x5d2$RspGetInfo>() { // from class: tencent.im.oidb.cmd0x5d2.oidb_0x5d2$RspGetInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"group_info", "login_info", "time", "frd_info", "frd_delete"}, new Object[]{null, null, 0, null, 0L}, oidb_0x5d2$RspGetInfo.class);
        public final PBRepeatMessageField<oidb_0x5d2$GroupInfo> group_info = PBField.initRepeatMessage(oidb_0x5d2$GroupInfo.class);
        public final PBRepeatMessageField<oidb_0x5d2$LoginInfo> login_info = PBField.initRepeatMessage(oidb_0x5d2$LoginInfo.class);
        public final PBUInt32Field time = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x5d2$FriendInfo> frd_info = PBField.initRepeatMessage(oidb_0x5d2$FriendInfo.class);
        public final PBRepeatField<Long> frd_delete = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
}
