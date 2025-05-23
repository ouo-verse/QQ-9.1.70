package tencent.im.troop.findtroop;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$GetTabRecommendReq extends MessageMicro<TabRecommendPB$GetTabRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"tab", "filter_type", AppConstants.Key.SESSION_INFO, "source"}, new Object[]{0, 0, null, 0}, TabRecommendPB$GetTabRecommendReq.class);
    public final PBUInt32Field tab = PBField.initUInt32(0);
    public final PBRepeatField<Integer> filter_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public TabRecommendPB$Session session_info = new TabRecommendPB$Session();
    public final PBEnumField source = PBField.initEnum(0);
}
