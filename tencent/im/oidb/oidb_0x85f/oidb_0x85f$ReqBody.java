package tencent.im.oidb.oidb_0x85f;

import com.tencent.luggage.wxa.uf.n;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x85f$ReqBody extends MessageMicro<oidb_0x85f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, n.CTRL_INDEX}, new String[]{"msg_comm_param", "msg_read_score", "msg_read_list", "msg_match_check", "msg_gray_open"}, new Object[]{null, null, null, null, null}, oidb_0x85f$ReqBody.class);
    public oidb_0x85f$CommParamReq msg_comm_param = new MessageMicro<oidb_0x85f$CommParamReq>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$CommParamReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_portal", "bytes_version", "uint32_platform", "uint32_use_uin"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, oidb_0x85f$CommParamReq.class);
        public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
        public final PBUInt32Field uint32_use_uin = PBField.initUInt32(0);
    };
    public oidb_0x85f$ReadFaceScoreBatchReq msg_read_score = new MessageMicro<oidb_0x85f$ReadFaceScoreBatchReq>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$ReadFaceScoreBatchReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_req_list"}, new Object[]{null}, oidb_0x85f$ReadFaceScoreBatchReq.class);
        public final PBRepeatMessageField<oidb_0x85f$ReadFaceScoreReq> msg_req_list = PBField.initRepeatMessage(oidb_0x85f$ReadFaceScoreReq.class);
    };
    public oidb_0x85f$ReadScoreListReq msg_read_list = new MessageMicro<oidb_0x85f$ReadScoreListReq>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$ReadScoreListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint32_index_begin", "uint32_index_end", "uint32_dimension", "uint32_index_order", "uint32_day", "uint64_user_id"}, new Object[]{0, 0, 0, 0, 0, 0L}, oidb_0x85f$ReadScoreListReq.class);
        public final PBUInt32Field uint32_index_begin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_index_end = PBField.initUInt32(0);
        public final PBUInt32Field uint32_dimension = PBField.initUInt32(0);
        public final PBUInt32Field uint32_index_order = PBField.initUInt32(0);
        public final PBUInt32Field uint32_day = PBField.initUInt32(0);
        public final PBUInt64Field uint64_user_id = PBField.initUInt64(0);
    };
    public oidb_0x85f$MatchCheckReq msg_match_check = new MessageMicro<oidb_0x85f$MatchCheckReq>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$MatchCheckReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_match_user_id"}, new Object[]{0L}, oidb_0x85f$MatchCheckReq.class);
        public final PBRepeatField<Long> uint64_match_user_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_0x85f$GrayOpenReq msg_gray_open = new MessageMicro<oidb_0x85f$GrayOpenReq>() { // from class: tencent.im.oidb.oidb_0x85f.oidb_0x85f$GrayOpenReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x85f$GrayOpenReq.class);
    };
}
