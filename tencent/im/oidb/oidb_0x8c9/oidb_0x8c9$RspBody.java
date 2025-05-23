package tencent.im.oidb.oidb_0x8c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8c9$RspBody extends MessageMicro<oidb_0x8c9$RspBody> {
    public static final int OPT_INT32_SHOW_RED_POINT_MOBILE_FIELD_NUMBER = 3;
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    public static final int RPT_GROUP_APP_UNREAD_INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"opt_uint64_group_code", "rpt_group_app_unread_info", "opt_int32_show_red_point_mobile"}, new Object[]{0L, null, 0}, oidb_0x8c9$RspBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x8c9$GroupAppUnreadInfo> rpt_group_app_unread_info = PBField.initRepeatMessage(oidb_0x8c9$GroupAppUnreadInfo.class);
    public final PBInt32Field opt_int32_show_red_point_mobile = PBField.initInt32(0);
}
