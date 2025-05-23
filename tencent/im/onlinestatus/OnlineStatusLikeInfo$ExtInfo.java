package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$ExtInfo extends MessageMicro<OnlineStatusLikeInfo$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"click_times"}, new Object[]{0}, OnlineStatusLikeInfo$ExtInfo.class);
    public final PBUInt32Field click_times = PBField.initUInt32(0);
}
