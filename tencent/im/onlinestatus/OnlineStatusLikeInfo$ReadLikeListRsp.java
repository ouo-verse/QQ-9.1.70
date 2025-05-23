package tencent.im.onlinestatus;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$ReadLikeListRsp extends MessageMicro<OnlineStatusLikeInfo$ReadLikeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, OnlineStatusLikeInfo$ReadLikeListRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
