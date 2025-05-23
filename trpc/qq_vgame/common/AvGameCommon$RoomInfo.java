package trpc.qq_vgame.common;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameCommon$RoomInfo extends MessageMicro<AvGameCommon$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64, 72, 80, 88}, new String[]{"seq", "roomid", PhotoCacheData.OWNER_UIN, "game_status", CrashRtInfoHolder.BeaconKey.GAME_NAME, "users", "room_create_ts", "match_status", "match_tag", "opened_match", "create_from"}, new Object[]{0L, 0L, 0L, 0, "", null, 0, 0, 0, Boolean.FALSE, 0}, AvGameCommon$RoomInfo.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
    public final PBEnumField game_status = PBField.initEnum(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBRepeatMessageField<AvGameCommon$RoomUserInfo> users = PBField.initRepeatMessage(AvGameCommon$RoomUserInfo.class);
    public final PBUInt32Field room_create_ts = PBField.initUInt32(0);
    public final PBUInt32Field match_status = PBField.initUInt32(0);
    public final PBEnumField match_tag = PBField.initEnum(0);
    public final PBBoolField opened_match = PBField.initBool(false);
    public final PBEnumField create_from = PBField.initEnum(0);
}
