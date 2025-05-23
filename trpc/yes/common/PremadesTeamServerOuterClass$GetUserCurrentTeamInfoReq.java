package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq extends MessageMicro<PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"game_id", "uid", "display_uid", "display_user_id"}, new Object[]{0, 0L, 0L, null}, PremadesTeamServerOuterClass$GetUserCurrentTeamInfoReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field display_uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId display_user_id = new CommonOuterClass$QQUserId();
}
