package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StUserRecomInfoBusiData extends MessageMicro<QQCircleFeedBase$StUserRecomInfoBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"pattonType", "recomSource", "bannerData"}, new Object[]{0, 0, null}, QQCircleFeedBase$StUserRecomInfoBusiData.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBUInt32Field recomSource = PBField.initUInt32(0);
    public QQCircleFeedBase$StUinBannerData bannerData = new QQCircleFeedBase$StUinBannerData();
}
