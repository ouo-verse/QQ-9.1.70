package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage$Message;
import QTimedMessage.QTimedMessage$User;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x75f$ReqBody extends MessageMicro<cmd0x75f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66}, new String[]{"uint64_appid", "uint32_subcmd", "msg_add_req", "msg_delete_req", "msg_get_list_req", "msg_update_req", "msg_get_one_req", "msg_add_batch_req"}, new Object[]{0L, 0, null, null, null, null, null, null}, cmd0x75f$ReqBody.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x75f$AddReq msg_add_req = new MessageMicro<cmd0x75f$AddReq>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$AddReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_message"}, new Object[]{null}, cmd0x75f$AddReq.class);
        public QTimedMessage$Message msg_message = new QTimedMessage$Message();
    };
    public cmd0x75f$DeleteReq msg_delete_req = new MessageMicro<cmd0x75f$DeleteReq>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$DeleteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg_id"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x75f$DeleteReq.class);
        public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x75f$GetListReq msg_get_list_req = new MessageMicro<cmd0x75f$GetListReq>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$GetListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg_owner", "uint64_end_time", "uint32_main_type", "rpt_uint32_sub_type"}, new Object[]{null, 0L, 0, 0}, cmd0x75f$GetListReq.class);
        public QTimedMessage$User msg_owner = new QTimedMessage$User();
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
        public final PBRepeatField<Integer> rpt_uint32_sub_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public cmd0x75f$UpdateReq msg_update_req = new MessageMicro<cmd0x75f$UpdateReq>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$UpdateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_message"}, new Object[]{null}, cmd0x75f$UpdateReq.class);
        public QTimedMessage$Message msg_message = new QTimedMessage$Message();
    };
    public cmd0x75f$GetOneReq msg_get_one_req = new MessageMicro<cmd0x75f$GetOneReq>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$GetOneReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg_id"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x75f$GetOneReq.class);
        public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x75f$AddBatchReq msg_add_batch_req = new cmd0x75f$AddBatchReq();
}
