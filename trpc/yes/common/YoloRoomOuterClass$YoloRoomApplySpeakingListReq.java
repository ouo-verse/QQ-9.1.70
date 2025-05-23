package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomApplySpeakingListReq extends MessageMicro<YoloRoomOuterClass$YoloRoomApplySpeakingListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{AudienceReportConst.ROOM_ID, "list_start_score", "last_score"}, new Object[]{0L, 0L, 0L}, YoloRoomOuterClass$YoloRoomApplySpeakingListReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field list_start_score = PBField.initUInt64(0);
    public final PBUInt64Field last_score = PBField.initUInt64(0);
}
