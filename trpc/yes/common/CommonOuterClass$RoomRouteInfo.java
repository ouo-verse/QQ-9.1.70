package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CommonOuterClass$RoomRouteInfo extends MessageMicro<CommonOuterClass$RoomRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "room_type"}, new Object[]{0L, 0}, CommonOuterClass$RoomRouteInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
}
