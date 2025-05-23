package tencent.im.oidb.recheck_flag_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class recheck_flag_info$RecheckFlagInfo extends MessageMicro<recheck_flag_info$RecheckFlagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_uin", "uint64_fuin", "bool_has_redtouch", "uint32_recheck_num", "rpt_recheck_list"}, new Object[]{0L, 0L, Boolean.FALSE, 0, null}, recheck_flag_info$RecheckFlagInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public final PBBoolField bool_has_redtouch = PBField.initBool(false);
    public final PBUInt32Field uint32_recheck_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<recheck_flag_info$RecheckFlagItem> rpt_recheck_list = PBField.initRepeatMessage(recheck_flag_info$RecheckFlagItem.class);
}
