package tencent.im.onlinestatus;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusLikeInfo$GetLikeListRsp extends MessageMicro<OnlineStatusLikeInfo$GetLikeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 80, 90}, new String[]{"unread_num", "notify_items", WidgetCacheConstellationData.INTERVAL, "timeout", CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, null, 0, 0, 0, ByteStringMicro.EMPTY}, OnlineStatusLikeInfo$GetLikeListRsp.class);
    public final PBUInt32Field unread_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<OnlineStatusLikeInfo$NotifyItem> notify_items = PBField.initRepeatMessage(OnlineStatusLikeInfo$NotifyItem.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field timeout = PBField.initUInt32(0);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
