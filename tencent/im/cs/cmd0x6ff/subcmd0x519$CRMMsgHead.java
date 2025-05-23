package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x519$CRMMsgHead extends MessageMicro<subcmd0x519$CRMMsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 104}, new String[]{"uint32_crm_sub_cmd", "uint32_head_len", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "str_buf_sig", "uint64_pub_qq", "uint32_clienttype", "uint64_labor_uin", "str_labor_name", "uint64_puin"}, new Object[]{0, 0, 0, 0L, 0, 0, 0, "", 0L, 0, 0L, "", 0L}, subcmd0x519$CRMMsgHead.class);
    public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
    public final PBStringField str_buf_sig = PBField.initString("");
    public final PBUInt64Field uint64_pub_qq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_clienttype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_labor_uin = PBField.initUInt64(0);
    public final PBStringField str_labor_name = PBField.initString("");
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
}
