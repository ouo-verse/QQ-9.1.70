package tencent.im.troop.studyroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class self_study_room_troop$StudyRoomMenberInfoRsp extends MessageMicro<self_study_room_troop$StudyRoomMenberInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"member_count", "member_uins"}, new Object[]{0, ""}, self_study_room_troop$StudyRoomMenberInfoRsp.class);
    public final PBUInt32Field member_count = PBField.initUInt32(0);
    public final PBRepeatField<String> member_uins = PBField.initRepeat(PBStringField.__repeatHelper__);
}
