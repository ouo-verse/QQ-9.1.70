package trpc.qlive.trpc_room_global_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigReq extends MessageMicro<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"anchor_uid", "room_type"}, new Object[]{0L, 0}, TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
    public final PBEnumField room_type = PBField.initEnum(0);
}
