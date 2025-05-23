package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$GetLikeListReq extends MessageMicro<OnlineStatusLikeInfo$GetLikeListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"time"}, new Object[]{0L}, OnlineStatusLikeInfo$GetLikeListReq.class);
    public final PBUInt64Field time = PBField.initUInt64(0);
}
