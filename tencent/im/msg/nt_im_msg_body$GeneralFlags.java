package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_im_msg_body$GeneralFlags extends MessageMicro<nt_im_msg_body$GeneralFlags> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField babyq_guide_msg_cookie;
    public final PBBytesField bytes_pb_reserve;
    public final PBBytesField bytes_rp_id;
    public final PBBytesField bytes_rp_index;
    public final PBUInt32Field long_text_flag;
    public final PBBytesField long_text_resid;
    public final PBUInt32Field uin32_expert_flag;
    public final PBUInt32Field uint32_bubble_sub_id;
    public final PBUInt32Field uint32_glamour_level;
    public final PBUInt32Field uint32_group_type;
    public final PBUInt32Field uint32_member_level;
    public final PBUInt32Field uint32_olympic_torch;
    public final PBUInt32Field uint32_prp_fold;
    public final PBUInt32Field uint32_to_uin_flag;
    public final PBUInt64Field uint64_group_rank_seq;
    public final PBUInt64Field uint64_pendant_id;
    public final PBUInt32Field uint32_bubble_diy_text_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag_new = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 146, 154}, new String[]{"uint32_bubble_diy_text_id", "uint32_group_flag_new", "uint64_uin", "bytes_rp_id", "uint32_prp_fold", "long_text_flag", "long_text_resid", "uint32_group_type", "uint32_to_uin_flag", "uint32_glamour_level", "uint32_member_level", "uint64_group_rank_seq", "uint32_olympic_torch", "babyq_guide_msg_cookie", "uin32_expert_flag", "uint32_bubble_sub_id", "uint64_pendant_id", "bytes_rp_index", "bytes_pb_reserve"}, new Object[]{0, 0, 0L, byteStringMicro, 0, 0, byteStringMicro, 0, 0, 0, 0, 0L, 0, byteStringMicro, 0, 0, 0L, byteStringMicro, byteStringMicro}, nt_im_msg_body$GeneralFlags.class);
    }

    public nt_im_msg_body$GeneralFlags() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_rp_id = PBField.initBytes(byteStringMicro);
        this.uint32_prp_fold = PBField.initUInt32(0);
        this.long_text_flag = PBField.initUInt32(0);
        this.long_text_resid = PBField.initBytes(byteStringMicro);
        this.uint32_group_type = PBField.initUInt32(0);
        this.uint32_to_uin_flag = PBField.initUInt32(0);
        this.uint32_glamour_level = PBField.initUInt32(0);
        this.uint32_member_level = PBField.initUInt32(0);
        this.uint64_group_rank_seq = PBField.initUInt64(0L);
        this.uint32_olympic_torch = PBField.initUInt32(0);
        this.babyq_guide_msg_cookie = PBField.initBytes(byteStringMicro);
        this.uin32_expert_flag = PBField.initUInt32(0);
        this.uint32_bubble_sub_id = PBField.initUInt32(0);
        this.uint64_pendant_id = PBField.initUInt64(0L);
        this.bytes_rp_index = PBField.initBytes(byteStringMicro);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
