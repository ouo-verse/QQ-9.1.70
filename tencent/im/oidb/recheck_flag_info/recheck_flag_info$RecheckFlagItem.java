package tencent.im.oidb.recheck_flag_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class recheck_flag_info$RecheckFlagItem extends MessageMicro<recheck_flag_info$RecheckFlagItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_flag", "uint32_cur_level", "uint32_lst_level"}, new Object[]{0, 0, 0}, recheck_flag_info$RecheckFlagItem.class);
    public final PBInt32Field uint32_flag = PBField.initInt32(0);
    public final PBInt32Field uint32_cur_level = PBField.initInt32(0);
    public final PBInt32Field uint32_lst_level = PBField.initInt32(0);
}
