package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$ReqSystemMsgRead extends MessageMicro<structmsg$ReqSystemMsgRead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"latest_friend_seq", "latest_group_seq", "type", "checktype", "uint32_req_msg_type"}, new Object[]{0L, 0L, 0, 1, 0}, structmsg$ReqSystemMsgRead.class);
    public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0);
    public final PBUInt64Field latest_group_seq = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBEnumField checktype = PBField.initEnum(1);
    public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
}
