package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sso2sns_0x3_blocklist$RspBodyGetBlockList extends MessageMicro<sso2sns_0x3_blocklist$RspBodyGetBlockList> {
    public static final int FIXED32_GET_TIME_FIELD_NUMBER = 2;
    public static final int RPT_MSG_BLOCK_UIN_INFO_FIELD_NUMBER = 6;
    public static final int UINT32_COMPLETED_FIELD_NUMBER = 4;
    public static final int UINT32_GET_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_NOW_POS_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32, 40, 50}, new String[]{"uint64_uin", "fixed32_get_time", "uint32_get_type", "uint32_completed", "uint32_now_pos", "rpt_msg_block_uin_info"}, new Object[]{0L, 0, 0, 0, 0, null}, sso2sns_0x3_blocklist$RspBodyGetBlockList.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBFixed32Field fixed32_get_time = PBField.initFixed32(0);
    public final PBUInt32Field uint32_get_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now_pos = PBField.initUInt32(0);
    public final PBRepeatMessageField<sso2sns_0x3_blocklist$BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(sso2sns_0x3_blocklist$BlockUinInfo.class);
}
