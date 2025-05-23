package qqcircle;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCountergroup$GetGroupCountRsp extends MessageMicro<QQCircleCountergroup$GetGroupCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56}, new String[]{"extInfo", "count", "hasMore", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "content", "iconUrl", "latestFeedTime"}, new Object[]{null, 0, 0, 0, "", "", 0}, QQCircleCountergroup$GetGroupCountRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field hasMore = PBField.initUInt32(0);
    public final PBUInt32Field timeInterval = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBUInt32Field latestFeedTime = PBField.initUInt32(0);
}
