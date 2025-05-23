package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.square.detail.BaseDetailFragmentConfig;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$LikeItem extends MessageMicro<OnlineStatusLikeInfo$LikeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{BaseDetailFragmentConfig.LIKE_TYPE, "ext_info"}, new Object[]{0, ByteStringMicro.EMPTY}, OnlineStatusLikeInfo$LikeItem.class);
    public final PBUInt32Field like_type = PBField.initUInt32(0);
    public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
