package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$StAlbumFeedIndex extends MessageMicro<QQCircleCounterMsg$StAlbumFeedIndex> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"feedId", "author", WadlProxyConsts.CREATE_TIME}, new Object[]{"", "", 0}, QQCircleCounterMsg$StAlbumFeedIndex.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBStringField author = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
}
