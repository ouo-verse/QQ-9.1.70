package tencent.intimate_relation_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class intimate_relation_ext$IntimateRelationExtMsg extends MessageMicro<intimate_relation_ext$IntimateRelationExtMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 800, 808, 8000}, new String[]{"uint64_upgrade_push_time", "uint64_downgrade_push_time", "uint64_egalitarian_soon_push_time", "uint64_upgrade_time", "uint64_downgrade_time", "uint64_chat_days_start_time", "uint64_chat_days_end_time", "uint64_icon_status"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, intimate_relation_ext$IntimateRelationExtMsg.class);
    public final PBUInt64Field uint64_upgrade_push_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_downgrade_push_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_egalitarian_soon_push_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_upgrade_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_downgrade_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_chat_days_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_chat_days_end_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_icon_status = PBField.initUInt64(0);
}
