package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomDataInfo extends MessageMicro<YoloRoomOuterClass$YoloRoomDataInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80}, new String[]{"min_player_num", "max_player_num", "max_user_num", "max_speaking_num", "create_from", "guild_id", "channel_id", "channel_name", "sub_create_from", "game_id"}, new Object[]{0, 0, 0, 0, 0, 0L, 0L, "", 0, 0}, YoloRoomOuterClass$YoloRoomDataInfo.class);
    public final PBInt32Field min_player_num = PBField.initInt32(0);
    public final PBInt32Field max_player_num = PBField.initInt32(0);
    public final PBInt32Field max_user_num = PBField.initInt32(0);
    public final PBInt32Field max_speaking_num = PBField.initInt32(0);
    public final PBInt32Field create_from = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBInt32Field sub_create_from = PBField.initInt32(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
}
