package tencent.im.onlinestatus;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$CheckLikeRsp extends MessageMicro<OnlineStatusLikeInfo$CheckLikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 80, 90}, new String[]{"business_type", QZoneHelper.QZoneAlbumConstants.KEY_LIKE_INFO, CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, null, 0, ByteStringMicro.EMPTY}, OnlineStatusLikeInfo$CheckLikeRsp.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$UinLikeInfo> like_info = PBField.initRepeatMessage(OnlineStatusLikeInfo$UinLikeInfo.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
