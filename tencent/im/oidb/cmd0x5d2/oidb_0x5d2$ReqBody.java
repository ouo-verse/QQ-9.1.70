package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d2$ReqBody extends MessageMicro<oidb_0x5d2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"sub_cmd", "req_get_list", "req_get_info"}, new Object[]{0, null, null}, oidb_0x5d2$ReqBody.class);
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public oidb_0x5d2$ReqGetList req_get_list = new MessageMicro<oidb_0x5d2$ReqGetList>() { // from class: tencent.im.oidb.cmd0x5d2.oidb_0x5d2$ReqGetList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"seq"}, new Object[]{0}, oidb_0x5d2$ReqGetList.class);
        public final PBUInt32Field seq = PBField.initUInt32(0);
    };
    public oidb_0x5d2$ReqGetInfo req_get_info = new MessageMicro<oidb_0x5d2$ReqGetInfo>() { // from class: tencent.im.oidb.cmd0x5d2.oidb_0x5d2$ReqGetInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin_list"}, new Object[]{0L}, oidb_0x5d2$ReqGetInfo.class);
        public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
}
