package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$GuildLiveRoomJoinCondition extends MessageMicro<YoloTeamOuterClass$GuildLiveRoomJoinCondition> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"enter_condition", "guild_id", "channel_id", "appid"}, new Object[]{0, 0L, 0L, ""}, YoloTeamOuterClass$GuildLiveRoomJoinCondition.class);
    public final PBInt32Field enter_condition = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField appid = PBField.initString("");
}
