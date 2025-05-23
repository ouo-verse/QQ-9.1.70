package trpc.qq_vgame.stranger_match;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AvGameStrangerMatch$DelMatchRoomReq extends MessageMicro<AvGameStrangerMatch$DelMatchRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"roomid", "type", "shard_id", PhotoCacheData.OWNER_UIN}, new Object[]{0L, 0, 0, 0L}, AvGameStrangerMatch$DelMatchRoomReq.class);
    public final PBUInt64Field roomid = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field shard_id = PBField.initUInt32(0);
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
}
