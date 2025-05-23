package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$SendListQueryRsp extends MessageMicro<cmd0x346$SendListQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"int32_ret_code", "str_ret_msg", "uint32_file_tot_count", "uint32_begin_index", "uint32_rsp_file_count", "uint32_is_end", "uint64_tot_limit", "uint64_used_limit", "rpt_msg_file_list"}, new Object[]{0, "", 0, 0, 0, 0, 0L, 0L, null}, cmd0x346$SendListQueryRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_file_tot_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0);
    public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x346$FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346$FileInfo.class);
}
