package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x51b$ReqBody extends MessageMicro<subcmd0x51b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_cmd", "msg_get_single_roam_msg_req", "msg_get_single_cluster_msg_req", "msg_del_single_cluster_msg_req"}, new Object[]{0, null, null, null}, subcmd0x51b$ReqBody.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public subcmd0x51b$GetSingleRoamMsgReq msg_get_single_roam_msg_req = new MessageMicro<subcmd0x51b$GetSingleRoamMsgReq>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$GetSingleRoamMsgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17}, new String[]{"uint64_puin", "fixed64_last_msg_id"}, new Object[]{0L, 0L}, subcmd0x51b$GetSingleRoamMsgReq.class);
        public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
        public final PBFixed64Field fixed64_last_msg_id = PBField.initFixed64(0);
    };
    public subcmd0x51b$GetSingleClusterMsgReq msg_get_single_cluster_msg_req = new MessageMicro<subcmd0x51b$GetSingleClusterMsgReq>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$GetSingleClusterMsgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25}, new String[]{"uint64_puin", "bytes_cluster_id", "rpt_fixed64_msgid_list"}, new Object[]{0L, ByteStringMicro.copyFromUtf8(""), 0L}, subcmd0x51b$GetSingleClusterMsgReq.class);
        public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
        public final PBBytesField bytes_cluster_id = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
        public final PBRepeatField<Long> rpt_fixed64_msgid_list = PBField.initRepeat(PBFixed64Field.__repeatHelper__);
    };
    public subcmd0x51b$DelSingleClusterMsgReq msg_del_single_cluster_msg_req = new MessageMicro<subcmd0x51b$DelSingleClusterMsgReq>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x51b$DelSingleClusterMsgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_puin", "bytes_cluster_id"}, new Object[]{0L, ByteStringMicro.copyFromUtf8("")}, subcmd0x51b$DelSingleClusterMsgReq.class);
        public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
        public final PBBytesField bytes_cluster_id = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    };
}
