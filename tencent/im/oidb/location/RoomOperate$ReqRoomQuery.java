package tencent.im.oidb.location;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$ReqRoomQuery extends MessageMicro<RoomOperate$ReqRoomQuery> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"room_key", "no_limit", AudienceReportConst.CLIENT_TYPE}, new Object[]{null, Boolean.FALSE, 1}, RoomOperate$ReqRoomQuery.class);
    public qq_lbs_share$RoomKey room_key = new qq_lbs_share$RoomKey();
    public final PBBoolField no_limit = PBField.initBool(false);
    public final PBEnumField client_type = PBField.initEnum(1);
}
