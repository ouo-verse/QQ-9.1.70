package trpc.qq_vgame.stranger_match;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$AddMatchRoomReq extends MessageMicro<AvGameStrangerMatchV2$AddMatchRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "game_type", PhotoCacheData.OWNER_UIN, "from"}, new Object[]{0L, 0, 0L, 0}, AvGameStrangerMatchV2$AddMatchRoomReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
