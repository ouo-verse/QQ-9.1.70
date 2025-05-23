package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomEnterReq extends MessageMicro<YoloRoomOuterClass$YoloRoomEnterReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 48, 56, 64, 74, 80, 88, 98, 104, 114, 122, 130, 800}, new String[]{AudienceReportConst.ROOM_ID, IPhotoLogicFactory.ENTER_FROM, "voice_switch", "room_type", "guild_id", "from_room_id", "channel_id", "channel_name", "sub_enter_from", "live_uid", "tgpa_data_info", "ignore_online_route", "show_nick", "channel_tinyid", "show_avatar_url", "recommand_max_user_limit"}, new Object[]{0L, 0, 0, 0, 0L, 0L, 0L, "", 0, 0L, null, Boolean.FALSE, "", "", "", 0}, YoloRoomOuterClass$YoloRoomEnterReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field enter_from = PBField.initInt32(0);
    public final PBInt32Field voice_switch = PBField.initInt32(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field from_room_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBInt32Field sub_enter_from = PBField.initInt32(0);
    public final PBInt64Field live_uid = PBField.initInt64(0);
    public YoloRoomOuterClass$YoloRoomTgpaData tgpa_data_info = new YoloRoomOuterClass$YoloRoomTgpaData();
    public final PBBoolField ignore_online_route = PBField.initBool(false);
    public final PBStringField show_nick = PBField.initString("");
    public final PBStringField channel_tinyid = PBField.initString("");
    public final PBStringField show_avatar_url = PBField.initString("");
    public final PBInt32Field recommand_max_user_limit = PBField.initInt32(0);
}
