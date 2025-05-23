package tencent.im.userdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class userdata$FaceScore extends MessageMicro<userdata$FaceScore> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_facescore", "uint32_scored_people", "uint32_datenum", "uint32_high_score"}, new Object[]{0, 0, 0, 0}, userdata$FaceScore.class);
    public final PBUInt32Field uint32_facescore = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scored_people = PBField.initUInt32(0);
    public final PBUInt32Field uint32_datenum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_high_score = PBField.initUInt32(0);
}
