package tencent.im.troop.studyroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class self_study_room_troop$StudyRoomMemberInfoReq extends MessageMicro<self_study_room_troop$StudyRoomMemberInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"troop_uin"}, new Object[]{""}, self_study_room_troop$StudyRoomMemberInfoReq.class);
    public final PBStringField troop_uin = PBField.initString("");
}
