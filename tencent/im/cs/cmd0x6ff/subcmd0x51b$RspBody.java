package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x51b$RspBody extends MessageMicro<subcmd0x51b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_cmd", "msg_get_single_roam_msg_rep", "msg_get_single_cluster_msg_rep", "msg_del_single_cluster_msg_rep"}, new Object[]{0, null, null, null}, subcmd0x51b$RspBody.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public subcmd0x51b$GetSingleRoamMsgRsp msg_get_single_roam_msg_rep = new MessageMicro<subcmd0x51b$GetSingleRoamMsgRsp>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$GetSingleRoamMsgRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "bytes_error_msg", "uint64_puin", "rpt_msg_msg_list"}, new Object[]{0, ByteStringMicro.copyFromUtf8(""), 0L, null}, subcmd0x51b$GetSingleRoamMsgRsp.class);
        public final PBEnumField ret_code = PBField.initEnum(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
        public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
        public final PBRepeatMessageField<msg_comm$Msg> rpt_msg_msg_list = PBField.initRepeatMessage(msg_comm$Msg.class);
    };
    public subcmd0x51b$GetSingleClusterMsgRsp msg_get_single_cluster_msg_rep = new MessageMicro<subcmd0x51b$GetSingleClusterMsgRsp>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$GetSingleClusterMsgRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "bytes_error_msg", "uint64_puin", "rpt_msg_msg_list"}, new Object[]{0, ByteStringMicro.copyFromUtf8(""), 0L, null}, subcmd0x51b$GetSingleClusterMsgRsp.class);
        public final PBEnumField ret_code = PBField.initEnum(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
        public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
        public final PBRepeatMessageField<msg_comm$Msg> rpt_msg_msg_list = PBField.initRepeatMessage(msg_comm$Msg.class);
    };
    public subcmd0x51b$DelSingleClusterMsgRsp msg_del_single_cluster_msg_rep = new MessageMicro<subcmd0x51b$DelSingleClusterMsgRsp>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$DelSingleClusterMsgRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.copyFromUtf8("")}, subcmd0x51b$DelSingleClusterMsgRsp.class);
        public final PBEnumField ret_code = PBField.initEnum(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    };
}
