package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7a8$ReqBody extends MessageMicro<cmd0x7a8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 88, 96, 104, 112, 120, 128, 136, 144}, new String[]{"uint64_req_uin", "uint32_only_obtained", "uint32_read_report", "uint32_sort_type", "uint32_only_new", "rpt_filter_medal_ids", "uint32_only_summary", "uint32_do_scan", "uint32_start_timestamp"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0}, cmd0x7a8$ReqBody.class);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_only_obtained = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_report = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_only_new = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_filter_medal_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_only_summary = PBField.initUInt32(0);
    public final PBUInt32Field uint32_do_scan = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_timestamp = PBField.initUInt32(0);
}
