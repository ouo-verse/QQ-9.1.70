package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GetNearbyRecommendTeamReq extends MessageMicro<PremadesTeamServerOuterClass$GetNearbyRecommendTeamReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uid", "user_id", "page", "page_size", "game_ids"}, new Object[]{0L, null, 0, 0, 0}, PremadesTeamServerOuterClass$GetNearbyRecommendTeamReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field page_size = PBField.initInt32(0);
    public final PBRepeatField<Integer> game_ids = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
