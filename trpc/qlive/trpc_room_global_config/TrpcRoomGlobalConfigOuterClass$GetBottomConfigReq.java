package trpc.qlive.trpc_room_global_config;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcRoomGlobalConfigOuterClass$GetBottomConfigReq extends MessageMicro<TrpcRoomGlobalConfigOuterClass$GetBottomConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "room_type"}, new Object[]{0L, 0}, TrpcRoomGlobalConfigOuterClass$GetBottomConfigReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt32Field room_type = PBField.initUInt32(0);
}
