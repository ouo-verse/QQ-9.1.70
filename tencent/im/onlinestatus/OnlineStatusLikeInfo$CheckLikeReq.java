package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$CheckLikeReq extends MessageMicro<OnlineStatusLikeInfo$CheckLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"business_type", "uins"}, new Object[]{0, 0L}, OnlineStatusLikeInfo$CheckLikeReq.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
