package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage$Message;
import QTimedMessage.QTimedMessage$User;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x75f$RspBody extends MessageMicro<cmd0x75f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66}, new String[]{"uint64_appid", "uint32_subcmd", "msg_add_rsp", "msg_delete_rsp", "msg_get_list_rsp", "msg_update_rsp", "msg_get_one_rsp", "msg_add_batch_rsp"}, new Object[]{0L, 0, null, null, null, null, null, null}, cmd0x75f$RspBody.class);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x75f$AddRsp msg_add_rsp = new MessageMicro<cmd0x75f$AddRsp>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$AddRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_message"}, new Object[]{null}, cmd0x75f$AddRsp.class);
        public QTimedMessage$Message msg_message = new QTimedMessage$Message();
    };
    public cmd0x75f$DeleteRsp msg_delete_rsp = new MessageMicro<cmd0x75f$DeleteRsp>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$DeleteRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg_id"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x75f$DeleteRsp.class);
        public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public cmd0x75f$GetListRsp msg_get_list_rsp = new MessageMicro<cmd0x75f$GetListRsp>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$GetListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"msg_owner", "uint64_start_time", "uint64_end_time", "rpt_messages"}, new Object[]{null, 0L, 0L, null}, cmd0x75f$GetListRsp.class);
        public QTimedMessage$User msg_owner = new QTimedMessage$User();
        public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<QTimedMessage$Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage$Message.class);
    };
    public cmd0x75f$UpdateRsp msg_update_rsp = new MessageMicro<cmd0x75f$UpdateRsp>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$UpdateRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x75f$UpdateRsp.class);
    };
    public cmd0x75f$GetOneRsp msg_get_one_rsp = new MessageMicro<cmd0x75f$GetOneRsp>() { // from class: tencent.im.oidb.cmd0x75f.cmd0x75f$GetOneRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_message"}, new Object[]{null}, cmd0x75f$GetOneRsp.class);
        public QTimedMessage$Message msg_message = new QTimedMessage$Message();
    };
    public cmd0x75f$AddBatchRsp msg_add_batch_rsp = new cmd0x75f$AddBatchRsp();
}
