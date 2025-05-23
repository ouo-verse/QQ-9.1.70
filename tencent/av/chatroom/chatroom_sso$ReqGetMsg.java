package tencent.av.chatroom;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class chatroom_sso$ReqGetMsg extends MessageMicro<chatroom_sso$ReqGetMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"room_key", "is_terminal_switch", AudienceReportConst.ROOM_ID}, new Object[]{null, Boolean.FALSE, 0L}, chatroom_sso$ReqGetMsg.class);
    public chatroom_sso$RoomKey room_key = new chatroom_sso$RoomKey();
    public final PBBoolField is_terminal_switch = PBField.initBool(false);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
