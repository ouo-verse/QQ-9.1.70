package tencent.im.userdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class userdata$FaceScoreCalc extends MessageMicro<userdata$FaceScoreCalc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_datenum", "uint32_numerator", "uint32_denominator"}, new Object[]{0, 0, 0}, userdata$FaceScoreCalc.class);
    public final PBUInt32Field uint32_datenum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_numerator = PBField.initUInt32(0);
    public final PBUInt32Field uint32_denominator = PBField.initUInt32(0);
}
