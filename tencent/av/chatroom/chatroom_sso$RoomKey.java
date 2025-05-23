package tencent.av.chatroom;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$RoomKey extends MessageMicro<chatroom_sso$RoomKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"type", "id", AudienceReportConst.ROOM_ID, "create_ts"}, new Object[]{0, 0L, 0L, 0}, chatroom_sso$RoomKey.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435895id = PBField.initUInt64(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
}
