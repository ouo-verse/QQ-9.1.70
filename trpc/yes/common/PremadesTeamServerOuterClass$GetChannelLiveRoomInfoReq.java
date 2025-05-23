package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq extends MessageMicro<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"game_id", "uid", "guild_id", "channel_id"}, new Object[]{0, 0L, "", ""}, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField guild_id = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
}
