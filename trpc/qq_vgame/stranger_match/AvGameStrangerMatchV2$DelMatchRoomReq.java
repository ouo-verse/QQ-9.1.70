package trpc.qq_vgame.stranger_match;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatchV2$DelMatchRoomReq extends MessageMicro<AvGameStrangerMatchV2$DelMatchRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"roomid", "game_type", PhotoCacheData.OWNER_UIN, "extr_info", "from"}, new Object[]{0L, 0, 0L, ByteStringMicro.EMPTY, 0}, AvGameStrangerMatchV2$DelMatchRoomReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt32Field game_type = PBField.initUInt32(0);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
    public final PBBytesField extr_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
