package trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 802, 808, 816, 824, 832, h.CTRL_INDEX, TVKTPCapability.HD_WIDTH}, new String[]{"op", "voice_switch", c.G, "no_user_type_check", "show_nick", "channel_tinyid", "bill_no", IPhotoLogicFactory.ENTER_FROM, "guild_id", "from_room_id", "channel_id", "channel_name", "sub_enter_from"}, new Object[]{0, 0, 0, 0, "", "", "", 0, 0L, 0L, 0L, "", 0}, YoloRoomOuterClass$YoloRoomSpeakingPosChangeCmd.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f437262op = PBField.initInt32(0);
    public final PBInt32Field voice_switch = PBField.initInt32(0);
    public final PBInt32Field pos = PBField.initInt32(0);
    public final PBInt32Field no_user_type_check = PBField.initInt32(0);
    public final PBStringField show_nick = PBField.initString("");
    public final PBStringField channel_tinyid = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public final PBInt32Field enter_from = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field from_room_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBInt32Field sub_enter_from = PBField.initInt32(0);
}
