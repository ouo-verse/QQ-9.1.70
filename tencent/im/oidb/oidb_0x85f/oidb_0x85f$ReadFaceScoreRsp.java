package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.userdata.userdata$FaceScore;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x85f$ReadFaceScoreRsp extends MessageMicro<oidb_0x85f$ReadFaceScoreRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_user_id", "uint32_score_of_mine", "msg_score", "uint32_show_user", "uint32_score_to_me"}, new Object[]{0L, 0, null, 0, 0}, oidb_0x85f$ReadFaceScoreRsp.class);
    public final PBUInt64Field uint64_user_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_score_of_mine = PBField.initUInt32(0);
    public final PBRepeatMessageField<userdata$FaceScore> msg_score = PBField.initRepeatMessage(userdata$FaceScore.class);
    public final PBUInt32Field uint32_show_user = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score_to_me = PBField.initUInt32(0);
}
