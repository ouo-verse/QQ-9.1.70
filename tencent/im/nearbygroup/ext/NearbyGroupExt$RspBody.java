package tencent.im.nearbygroup.ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NearbyGroupExt$RspBody extends MessageMicro<NearbyGroupExt$RspBody> {
    public static final int RPT_GROUP_LIST_FIELD_NUMBER = 2;
    public static final int STR_WORDING_FIELD_NUMBER = 3;
    public static final int UINT32_TOTAL_NUM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_total_num", "rpt_group_list", "str_wording"}, new Object[]{0, null, ""}, NearbyGroupExt$RspBody.class);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<NearbyGroupExt$GroupItem> rpt_group_list = PBField.initRepeatMessage(NearbyGroupExt$GroupItem.class);
    public final PBStringField str_wording = PBField.initString("");
}
