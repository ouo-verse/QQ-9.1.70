package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sso2sns_0x3_blocklist$ReqBodyDelBlockList extends MessageMicro<sso2sns_0x3_blocklist$ReqBodyDelBlockList> {
    public static final int RPT_UINT64_DEL_UIN_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "rpt_uint64_del_uin"}, new Object[]{0L, 0L}, sso2sns_0x3_blocklist$ReqBodyDelBlockList.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
