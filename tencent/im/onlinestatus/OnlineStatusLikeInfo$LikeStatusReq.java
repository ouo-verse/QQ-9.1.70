package tencent.im.onlinestatus;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$LikeStatusReq extends MessageMicro<OnlineStatusLikeInfo$LikeStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"business_type", "uin", "like_items", IPrefRecorder.AI_ELIMINATE_IS_CANCEL}, new Object[]{0, 0L, null, 0L}, OnlineStatusLikeInfo$LikeStatusReq.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$LikeItem> like_items = PBField.initRepeatMessage(OnlineStatusLikeInfo$LikeItem.class);
    public final PBUInt64Field is_cancel = PBField.initUInt64(0);
}
