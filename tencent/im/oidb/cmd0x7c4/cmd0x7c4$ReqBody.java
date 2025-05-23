package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c4$ReqBody extends MessageMicro<cmd0x7c4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_get_recommend_sn_frd_list_req", "msg_get_sn_frd_list_req", "uint32_client_ver"}, new Object[]{null, null, 0}, cmd0x7c4$ReqBody.class);
    public cmd0x7c4$GetRecommendSNFrdListReq msg_get_recommend_sn_frd_list_req = new MessageMicro<cmd0x7c4$GetRecommendSNFrdListReq>() { // from class: tencent.im.oidb.cmd0x7c4.cmd0x7c4$GetRecommendSNFrdListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_sequence", "uint32_start_idx", "uint32_req_num"}, new Object[]{0L, 0, 0, 0}, cmd0x7c4$GetRecommendSNFrdListReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
        public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public cmd0x7c4$GetSNFrdListReq msg_get_sn_frd_list_req = new cmd0x7c4$GetSNFrdListReq();
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
}
